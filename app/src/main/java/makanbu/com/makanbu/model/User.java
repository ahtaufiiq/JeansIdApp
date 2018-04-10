package makanbu.com.makanbu.model;

public class User {

    String email,nomerHandphone;

    public User() {
    }

    public User(String email, String nomerHandphone) {
        this.email = email;
        this.nomerHandphone = nomerHandphone;
    }

    public String getEmail() {
        return email;
    }

    public String getNomerHandphone() {
        return nomerHandphone;
    }
}
