package mohit.learn.java;

import mohit.learn.java.models.User;
import mohit.learn.java.services.DisplayService;
import mohit.learn.java.services.SplitUIService;
import mohit.learn.java.services.UserService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        User user1 = new User("1","MOHIT","MOHIT");
        User user2 = new User("2","ROHIT","ROHIT");
        User user3 = new User("3","JAIN","JAIN");
        UserService userService = new UserService();
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        SplitUIService sus = new SplitUIService(userService);
        sus.loadUI();

    }
}
