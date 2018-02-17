package ua.danit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UserDao {

    public static HashMap<Integer, User> userList = new HashMap<>();
    public static Set<User> usersLiked = new HashSet<>();
    public static Set<User> usersDisliked = new HashSet<>();

    {
        userList.put(1, new User(1, "Cat-Dog", "https://img.buzzfeed.com/buzzfeed-static/static/2017-07/6/15/asset/buzzfeed-prod-fastlane-03/sub-buzz-25189-1499368792-6.jpg?downsize=715:*&output-format=auto&output-quality=auto"));
        userList.put(2, new User(2, "Rik", "https://i.pinimg.com/236x/09/cd/f0/09cdf0d63f5cf955d0179742722b19bf--rick-and-morty-cartoons.jpg"));
        userList.put(3, new User(3, "Dr. John Zoidberg", "https://i.pinimg.com/736x/3b/a4/55/3ba455158a7d6106cba67d90d73fbb38--futurama-bender-cartoons.jpg"));
        userList.put(4, new User(4, "Fry", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaIDEARJZmEVAeWzyR_jnKfTX2MmTPkS3DTH_D_E_yT7I3ISizZw"));
        userList.put(5, new User(5, "Stan", "https://imgs.tuts.dragoart.com/how-to-draw-grunkle-stan-gravity-falls_1_000000012624_5.png"));
        userList.put(6, new User(6, "Homer", "https://static.highsnobiety.com/wp-content/uploads/2016/09/17115238/homer-simpsons-jobs-salaries-0.jpg    "));
    }

    public void addLikedUsersById(Integer id){
        usersLiked.add(userList.get(id));
    }

    public Set<User> likedUsers() {
        return usersLiked;
    }

    public User showLikedUsersById() {
        for(User e : userList.values()){
            if(!usersLiked.contains(e) && !usersDisliked.contains(e)){
                return e;
            }
        }
        return null;
    }
}
