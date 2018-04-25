package makanbu.com.makanbu.model;

public class User {

    String id, email, nomerHandphone, photo,photo2;

    public User() {
    }

    public User(String email, String nomerHandphone) {
        this.email = email;
        this.nomerHandphone = nomerHandphone;
    }

    public User(String id, String email, String nomerHandphone, String photo) {
        this.id = id;
        this.email = email;
        this.nomerHandphone = nomerHandphone;
        this.photo = photo;
    }

    public User(String id, String email, String nomerHandphone, String photo, String photo2) {
        this.email = email;
        this.nomerHandphone = nomerHandphone;
        this.photo = photo;
        this.photo2=photo2;
    }

    public String getPhoto2() {
        return photo2;
    }

    public String getPhoto() {
        return photo;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNomerHandphone() {
        return nomerHandphone;
    }
}
