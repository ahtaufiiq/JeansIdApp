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
    EditText editTextAlamat, editTextJumlah, editTextCatatan;
    TextView harga;
    String alamat;
    String jumlah;
    String catatan;
    String number;
    int total;
    String gambar, profile;
    String namaMenu, jumlahReview, hargaMakanan;
    int rating;

    ImageView imageView;
    TextView mNamaMakanan,mHargaMakanan,mJumlahReview;
    CircleImageView circleImageView;
    // [START declare_auth]
    private FirebaseAuth mAuth;
    DatabaseReference databaseOrder;
    private TextView textView4;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_order);

        mAuth = FirebaseAuth.getInstance();



        editTextJumlah = findViewById(R.id.editTextJumlah);
        editTextAlamat = findViewById(R.id.alamatPengiriman);
        editTextCatatan = findViewById(R.id.catatan);
        harga = findViewById(R.id.harga_makanan);
        textView3 = findViewById(R.id.textView3);

        textView4 = findViewById(R.id.textView4);
        editTextJumlah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int harga= Integer.parseInt(hargaMakanan);
                total= harga*Integer.parseInt(editTextJumlah.getText().toString());
               textView4.setText("Rp "+total);
            }
        });
        imageView=findViewById(R.id.img_masakan);
        mNamaMakanan=findViewById(R.id.namaMakanan);
        circleImageView= findViewById(R.id.avatar);
        mJumlahReview= findViewById(R.id.jumlahReview);

        if (getIntent() != null){
            getData();
            setData();
        }
        databaseOrder = FirebaseDatabase.getInstance().getReference("Order");
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
        harga.setText(hargaMakanan);
        textView3.setText("Rp "+hargaMakanan);
        textView4.setText("Rp "+hargaMakanan);
    }

    public void order(View view) {
        alamat = editTextAlamat.getText().toString();
        jumlah = editTextJumlah.getText().toString();
        catatan = editTextCatatan.getText().toString();
        hargaMakanan = harga.getText().toString();

        String id = databaseOrder.push().getKey();
        Order order = new Order(alamat, jumlah, catatan, hargaMakanan);
        databaseOrder.child(id).setValue(order);
        sendToWhatsapp();

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
