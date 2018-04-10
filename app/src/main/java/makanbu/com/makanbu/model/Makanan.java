package makanbu.com.makanbu.model;

public class Makanan {

    String namaMakanan;
    String hargaMakanan;
    String description;

    public Makanan() {
    }

    public Makanan(String namaMakanan, String hargaMakanan, String description) {
        this.namaMakanan = namaMakanan;
        this.hargaMakanan = hargaMakanan;
        this.description = description;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public String getHargaMakanan() {
        return hargaMakanan;
    }

    public String getDescription() {
        return description;
    }
}
