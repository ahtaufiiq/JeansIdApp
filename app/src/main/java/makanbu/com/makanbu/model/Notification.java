package makanbu.com.makanbu.model;

public class Notification {

    private String id, text;

    public Notification() {
    }

    public Notification(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
