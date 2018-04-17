package makanbu.com.makanbu.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Makanan  {

    private String gambar_card, profileImage_card;
    private String namaMenu_card, jumlahReview_card, hargaMakanan_card,phone_number;
    private int rating_card;

    public Makanan() {
    }

    public Makanan(String gambar_card, String profileImage_card, String namaMenu_card, String jumlahReview_card, String hargaMakanan_card, String phone_number, int rating_card) {
        this.gambar_card = gambar_card;
        this.profileImage_card = profileImage_card;
        this.namaMenu_card = namaMenu_card;
        this.jumlahReview_card = jumlahReview_card;
        this.hargaMakanan_card = hargaMakanan_card;
        this.phone_number = phone_number;
        this.rating_card = rating_card;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getGambar_card() {
        return gambar_card;
    }

    public String getProfileImage_card() {
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

//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(this.gambar_card);
//        dest.writeInt(this.profileImage_card);
//        dest.writeString(this.namaMenu_card);
//        dest.writeString(this.jumlahReview_card);
//        dest.writeString(this.hargaMakanan_card);
//        dest.writeInt(this.rating_card);
//    }
//
//    protected Makanan(Parcel in) {
//        this.gambar_card = in.readInt();
//        this.profileImage_card = in.readInt();
//        this.namaMenu_card = in.readString();
//        this.jumlahReview_card = in.readString();
//        this.hargaMakanan_card = in.readString();
//        this.rating_card = in.readInt();
//    }
//
//    public static final Parcelable.Creator<Makanan> CREATOR = new Parcelable.Creator<Makanan>() {
//        @Override
//        public Makanan createFromParcel(Parcel source) {
//            return new Makanan(source);
//        }
//
//        @Override
//        public Makanan[] newArray(int size) {
//            return new Makanan[size];
//        }
//    };
}
