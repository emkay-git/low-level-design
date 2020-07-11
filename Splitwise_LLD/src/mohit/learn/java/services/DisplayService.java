package mohit.learn.java.services;

import mohit.learn.java.data.UserDataStore;
import mohit.learn.java.models.User;

import java.util.ArrayList;
import java.util.List;

public class DisplayService {

    UserDataStore userDataStore;

    public DisplayService() {
        userDataStore = UserDataStore.getUserDataStoreInstance();
    }
    public List<String> showAllBalance() {
        List<User> users = this.userDataStore.getAllUser();
        List<String> balances = new ArrayList<>();
        users.forEach(user -> {
            balances.addAll(user.getUserBalanceList());
        });
        for(String item: balances) System.out.println(item);
        return balances;
    }

    public List<String> showBalanceForUser(User user) {
        List<String> balances =  user.getBalanceForCurrentUser();
        for(String item: balances) System.out.println(item);
        return balances;
    }
}
