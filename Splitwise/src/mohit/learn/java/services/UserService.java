package mohit.learn.java.services;

import mohit.learn.java.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
    }
    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUser(String name) {
        for(int i=0;i<userList.size();i++) {
            if(userList.get(i).getUserName().equals(name)) {
                return userList.get(i);
            }
        }
        throw new IllegalArgumentException("User not found");
    }

}
