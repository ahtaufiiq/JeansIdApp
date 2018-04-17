package makanbu.com.makanbu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import makanbu.com.makanbu.Constants;
import makanbu.com.makanbu.R;
import makanbu.com.makanbu.model.Makanan;

/**
 * Created by Labbaika Putri on 2/21/2018.
 */

public class DetailMenuActivity extends AppCompatActivity {

    ImageView gambar_card;
    CircleImageView profileImage_card;
    TextView namaMenu_card, jumlahReview_card, hargaMakanan_card;
    RatingBar rating_card;
    String gambar, profile;
    String namaMenu, jumlahReview, hargaMakanan;
    int rating;

    Makanan makanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        if (getIntent() != null) {
            getData();
            setData();
        }
    }

    private void setData() {
        gambar_card = findViewById(R.id.img_masakan);
        profileImage_card = findViewById(R.id.img_avatar_penjual);
        namaMenu_card = findViewById(R.id.tv_nama_makanan);
        jumlahReview_card = findViewById(R.id.tv_total_review);
        hargaMakanan_card = findViewById(R.id.tv_harga_makanan);
        rating_card = findViewById(R.id.rb_makanan);

        Glide.with(DetailMenuActivity.this)
                .load(gambar)
                .into(gambar_card);

        Glide.with(DetailMenuActivity.this)
                .load(profile)
                .into(profileImage_card);
        namaMenu_card.setText(namaMenu);
        jumlahReview_card.setText(jumlahReview+" Reviews");
        hargaMakanan_card.setText(hargaMakanan);
        rating_card.setNumStars(rating);
    }

    public void getData() {
        makanan= getIntent().getExtras().getParcelable(Constants.KEY_MAKANAN);
        gambar = makanan.getGambar_card();
        profile = makanan.getProfileImage_card();
        hargaMakanan = makanan.getHargaMakanan_card();
        namaMenu = makanan.getNamaMenu_card();
        jumlahReview = makanan.getJumlahReview_card();
        rating = makanan.getRating_card();
    }

    public void order(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Constants.KEY_MAKANAN,makanan);
        startActivity(intent);
    }
}
