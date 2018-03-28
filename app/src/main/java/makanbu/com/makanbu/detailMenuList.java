package makanbu.com.makanbu;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Labbaika Putri on 3/26/2018.
 */

public class detailMenuList {
    ImageView gambar_card, profileImage_card;
    TextView namaMenu_card, jumlahReview_card, hargaMakanan_card;
    RatingBar rating_card;

    public ImageView getGambar_card() {
        return gambar_card;
    }

    public void setGambar_card(ImageView gambar_card) {
        this.gambar_card = gambar_card;
    }

    public ImageView getProfileImage_card() {
        return profileImage_card;
    }

    public void setProfileImage_card(ImageView profileImage_card) {
        this.profileImage_card = profileImage_card;
    }

    public TextView getNamaMenu_card() {
        return namaMenu_card;
    }

    public void setNamaMenu_card(TextView namaMenu_card) {
        this.namaMenu_card = namaMenu_card;
    }

    public TextView getJumlahReview_card() {
        return jumlahReview_card;
    }

    public void setJumlahReview_card(TextView jumlahReview_card) {
        this.jumlahReview_card = jumlahReview_card;
    }

    public TextView getHargaMakanan_card() {
        return hargaMakanan_card;
    }

    public void setHargaMakanan_card(TextView hargaMakanan_card) {
        this.hargaMakanan_card = hargaMakanan_card;
    }

    public RatingBar getRating_card() {
        return rating_card;
    }

    public void setRating_card(RatingBar rating_card) {
        this.rating_card = rating_card;
    }
}
