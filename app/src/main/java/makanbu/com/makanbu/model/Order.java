package makanbu.com.makanbu.model;

public class Order {

    String alamat;
    String jumlah;
    String catatan;
    String hargaMakanan;

    public Order() {
    }

    public Order(String alamat, String jumlah, String catatan, String hargaMakanan) {
        this.alamat = alamat;
        this.jumlah = jumlah;
        this.catatan = catatan;
        this.hargaMakanan = hargaMakanan;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getCatatan() {
        return catatan;
    }

    public String getHargaMakanan() {
        return hargaMakanan;
    }
}
