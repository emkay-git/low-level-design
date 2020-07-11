package mohit.learn.java;

import mohit.learn.java.data.UserDataStore;
import mohit.learn.java.models.User;
import mohit.learn.java.ui.SplitwiseUI;

public class Main {


    public static void main(String[] args) {
	// write your code here
        UserDataStore userDataStore = UserDataStore.getUserDataStoreInstance();
        User user1 = new User("Mohit","1",0);
        User user2 = new User("Ishu","2",0);
        User user3 = new User("Jain","3",0);
        User user4 = new User("Gupta","4",0);

        userDataStore.saveUserById(user1);
        userDataStore.saveUserById(user2);
        userDataStore.saveUserById(user3);
        userDataStore.saveUserById(user4);

        SplitwiseUI ui = SplitwiseUI.loadUI();
        try{
            ui.takeInput();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}
