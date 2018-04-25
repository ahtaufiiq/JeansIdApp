package makanbu.com.makanbu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import makanbu.com.makanbu.Constants;
import makanbu.com.makanbu.R;
import makanbu.com.makanbu.model.Makanan;

/**
 * Created by Labbaika Putri on 2/21/2018.
 */

public class DetailMenuActivity extends AppCompatActivity {

    @BindView(R.id.img_masakan) ImageView gambar_card;
    @BindView(R.id.img_avatar_penjual)CircleImageView profileImage_card;
    @BindView(R.id.tv_nama_makanan) TextView namaMenu_card;
    @BindView(R.id.tv_total_review) TextView jumlahReview_card;
    @BindView(R.id.tv_harga_makanan) TextView hargaMakanan_card;
    @BindView(R.id.rb_makanan) RatingBar rating_card;


    String gambar, profile,namaMenu, jumlahReview, hargaMakanan;
    int rating;

    Makanan makanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        ButterKnife.bind(this);

        if (getIntent() != null) {
            getData();
            setData();
        }

    }

    private void setData() {

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

    public void onBack(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void viewAll(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void allReviews(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}
