package makanbu.com.makanbu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Labbaika Putri on 2/21/2018.
 */

public class DetailMenuActivity extends AppCompatActivity {

    ImageView gambar_card, profileImage_card;
    TextView namaMenu_card, jumlahReview_card, hargaMakanan_card;
    RatingBar rating_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gambar_card = findViewById(R.id.gambar_card);
        profileImage_card = findViewById(R.id.profileImage_card);
        namaMenu_card = findViewById(R.id.namaMenu_card);
        jumlahReview_card = findViewById(R.id.jumlahReview_card);
        hargaMakanan_card = findViewById(R.id.hargaMakanan_card);
        rating_card = findViewById(R.id.rating_card);


    }

    public void order(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
}
