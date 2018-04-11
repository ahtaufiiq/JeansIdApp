package makanbu.com.makanbu.model;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Makanan {

    int gambar_card, profileImage_card;
    String namaMenu_card, jumlahReview_card, hargaMakanan_card;
    int rating_card;

    public Makanan(int gambar_card, int profileImage_card, String namaMenu_card, String jumlahReview_card, String hargaMakanan_card, int rating_card) {
        this.gambar_card = gambar_card;
        this.profileImage_card = profileImage_card;
        this.namaMenu_card = namaMenu_card;
        this.jumlahReview_card = jumlahReview_card;
        this.hargaMakanan_card = hargaMakanan_card;
        this.rating_card = rating_card;
    }

    public int getGambar_card() {
        return gambar_card;
    }

    public int getProfileImage_card() {
        return profileImage_card;
    }

    public void setGambar_card(int gambar_card) {
        this.gambar_card = gambar_card;
    }

    public void setProfileImage_card(int profileImage_card) {
        this.profileImage_card = profileImage_card;
    }

    public void setNamaMenu_card(String namaMenu_card) {
        this.namaMenu_card = namaMenu_card;
    }

    public void setJumlahReview_card(String jumlahReview_card) {
        this.jumlahReview_card = jumlahReview_card;
    }

    public void setHargaMakanan_card(String hargaMakanan_card) {
        this.hargaMakanan_card = hargaMakanan_card;
    }

    public void setRating_card(int rating_card) {
        this.rating_card = rating_card;
    }

    public String getNamaMenu_card() {
        return namaMenu_card;
    }

    public String getJumlahReview_card() {
        return jumlahReview_card;
    }

    public String getHargaMakanan_card() {
        return hargaMakanan_card;
    }

    public int getRating_card() {
        return rating_card;
    }
}
