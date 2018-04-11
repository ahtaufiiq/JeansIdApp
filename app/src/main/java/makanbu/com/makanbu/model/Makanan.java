package makanbu.com.makanbu.model;

public class Makanan {

    private int gambar_card, profileImage_card;
    private String namaMenu_card, jumlahReview_card, hargaMakanan_card;
    private int rating_card;

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
