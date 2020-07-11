package mohit.learn.java.data;

import mohit.learn.java.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDataStore {

    private List<User> users;
    private static UserDataStore userDataStore;
    private UserDataStore() {
        users = new ArrayList<>();

    }

    public static UserDataStore getUserDataStoreInstance() {
        if(userDataStore==null) {
            userDataStore = new UserDataStore();
        }
        return userDataStore;
    }

    public List<User> getAllUser() {
        return users;
    }

    public User getUserById(String userId) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getId().equals(userId))
                return users.get(i);
        }
        return null;
    }

    public void saveUserById(User user) {
        users.add(user);
    }
}
