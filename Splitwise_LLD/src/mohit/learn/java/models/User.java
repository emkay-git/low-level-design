package mohit.learn.java.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private String id;
    private double balance;
    private Map<User,Double> userBalanceMap;

    public void setUserBalanceMap(Map<User, Double> userBalanceMap) {
        this.userBalanceMap = userBalanceMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User(String name, String id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        userBalanceMap = new HashMap<>();

    }

    public boolean updateBalance(User userId, double amount) {
        if(userBalanceMap.get(userId)==null) userBalanceMap.put(userId,amount);
         userBalanceMap.put(userId,amount);
         return true;
    }

    public List<String> getUserBalanceList() {
        List<String> userBalanceList = new ArrayList<>();
        if(userBalanceMap==null) return userBalanceList;
        for(Map.Entry<User,Double> entry: userBalanceMap.entrySet()) {
            User user = entry.getKey();
            double balance = entry.getValue();
            if(balance>0) {
                userBalanceList.add(user.name+" owes "+balance+" "+this.name);
            }
        }
        System.out.println(userBalanceList.size());
        return userBalanceList;
    }

    public List<String> getBalanceForCurrentUser() {
        List<String> userBalanceList = new ArrayList<>();
        if(userBalanceList == null) return userBalanceList;
        for(Map.Entry<User,Double> entry: userBalanceMap.entrySet()) {
            User user = entry.getKey();
            double balance = entry.getValue();
            if(balance>0) {
                userBalanceList.add(user.name+" owes "+balance+" "+this.name);
            }
            else userBalanceList.add(this.name+" owes "+balance+" "+user.name);
        }
        return userBalanceList;
    }

}
