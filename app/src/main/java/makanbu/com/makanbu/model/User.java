package makanbu.com.makanbu.model;

public class User {

    String id,email,nomerHandphone,photo;

    public User() {
    }

    public User(String email, String nomerHandphone) {
        this.email = email;
        this.nomerHandphone = nomerHandphone;
    }

    public User(String id,String email, String nomerHandphone, String photo) {
        this.email = email;
        this.nomerHandphone = nomerHandphone;
        this.photo = photo;
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
