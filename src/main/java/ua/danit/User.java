package ua.danit;

import java.util.Objects;

public class User {

    public int id;
    public String name;
    public String imgUrl;

    public User(int id, String name, String imgUrl) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(imgUrl, user.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imgUrl, id);
    }
}
