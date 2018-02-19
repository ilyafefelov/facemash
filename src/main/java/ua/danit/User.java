package ua.danit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    public int id;
    public String name;
    public String imgUrl;
    public List<String> messages;


    public User(int id, String name, String imgUrl) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.messages = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<String> getMessages() {
        return messages;
    }
}
