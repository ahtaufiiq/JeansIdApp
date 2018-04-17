package makanbu.com.makanbu.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URISyntaxException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import makanbu.com.makanbu.Constants;
import makanbu.com.makanbu.R;
import makanbu.com.makanbu.model.Makanan;
import makanbu.com.makanbu.model.Order;

/**
 * Created by taufiq on 28/02/18.
 */

public class OrderActivity extends Activity {

    private static final String TAG="Get Intent";
    private List<ApplicationInfo> m_appList;
    public static final String PACKAGE_NAME_WA = "com.whatsapp";
    String alamat,jumlah,catatan,number,gambar, profile,namaMenu, jumlahReview, hargaMakanan;
    int rating,total;

    @BindView(R.id.et_alamat) EditText mAlamat;

    @BindView(R.id.et_catatan) EditText mCatatan;

    @BindView(R.id.tv_harga_satuan) TextView mHargaSatuan;

    @BindView(R.id.tv_harga_makanan) TextView mHargaMakanan;

    @BindView(R.id.img_masakan) ImageView imageView;

    @BindView(R.id.tv_nama_makanan) TextView mNamaMakanan;

    @BindView(R.id.tv_jumlah_review) TextView mJumlahReview;

    @BindView(R.id.img_avatar) CircleImageView circleImageView;

    @BindView(R.id.tv_total_harga) TextView mTotalHarga;

    EditText mJumlahOrder;

    DatabaseReference databaseOrder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_order);

        ButterKnife.bind(this);

        databaseOrder = FirebaseDatabase.getInstance().getReference("Order");

        mJumlahOrder= findViewById(R.id.et_jumlah_order);
        mJumlahOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int harga= Integer.parseInt(hargaMakanan);
                total= harga*Integer.parseInt(mJumlahOrder.getText().toString());
               mTotalHarga.setText("Rp "+total);
            }
        });

        if (getIntent() != null){
            getData();
            setData();
        }
    }

    public void getData() {
        Makanan makanan = getIntent().getExtras().getParcelable(Constants.KEY_MAKANAN);
        gambar = makanan.getGambar_card();
        profile = makanan.getProfileImage_card();
        hargaMakanan = makanan.getHargaMakanan_card();
        namaMenu = makanan.getNamaMenu_card();
        jumlahReview = makanan.getJumlahReview_card();
        rating = makanan.getRating_card();
        number = makanan.getPhone_number();
    }

    private void setData() {
        Glide.with(OrderActivity.this)
                .load(gambar)
                .into(imageView);
        Glide.with(OrderActivity.this)
                .load(profile)
                .into(circleImageView);
        mNamaMakanan.setText(namaMenu);
        mJumlahReview.setText(jumlahReview);
        mHargaMakanan.setText(hargaMakanan);
        mHargaSatuan.setText("Rp "+hargaMakanan);
        mTotalHarga.setText("Rp "+hargaMakanan);
    }

    public void order(View view) {
        alamat = mAlamat.getText().toString();
        jumlah = mJumlahOrder.getText().toString();
        catatan = mCatatan.getText().toString();
        hargaMakanan = mHargaSatuan.getText().toString();

        String id = databaseOrder.push().getKey();
        Order order = new Order(alamat, jumlah, catatan, hargaMakanan);
        databaseOrder.child(id).setValue(order);
        sendToWhatsapp();

    }

    public void sendToWhatsapp() {
        String nomor=number;
        String text ="Beli "+ namaMenu+" Sebanyak " + jumlah+
                "\n Totalnya Rp "+ total+
                "\n Masih ada gk mas"+
                "\n ke "+ alamat;


        String[] kata = text.split("\\s+");
        String kalimat="";
        for (int i =0;i<kata.length;i++){
            kalimat+=kata[i]+"%20";
        }
        String url ="https://api.whatsapp.com/send?phone="+nomor+"&text="+kalimat;
        Log.d("Testing",kalimat);
        if (checkWAInstalled()){
            try {
                Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                startActivity(intent);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "You Don't have Whatsapp App", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean checkWAInstalled(){
        PackageManager pm = getPackageManager();
        m_appList = pm.getInstalledApplications(0);
        boolean WAInstallFlag = false;
        for (ApplicationInfo ai : m_appList) {
            if(ai.packageName.equals(PACKAGE_NAME_WA)){
                WAInstallFlag = true;
                break;
            }
        }
        return WAInstallFlag;
    }
}
