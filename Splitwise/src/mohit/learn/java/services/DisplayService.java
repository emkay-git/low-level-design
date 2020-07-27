package mohit.learn.java.services;

import mohit.learn.java.models.Expense;
import mohit.learn.java.models.Split;
import mohit.learn.java.models.User;
import java.util.*;


public class DisplayService {

    List<User> users;
    Map<String, User> userMap;
    Map<String,Map<String,Double>> balance;


    public DisplayService(UserService userService) {
        balance = new HashMap<String, Map<String, Double>>();
        users = userService.getUserList();
        for(int i=0;i<users.size();i++) {
            balance.put(users.get(i).getUserName(),new HashMap<>());
        }
        userMap = new HashMap<>();

    }

    public void initExpense(Expense expense) {
        List<Split> splitList = expense.getDistribution();
        String paidBy = expense.getPaidBy().getUserName();
        for(Split split: splitList) {

            Map<String,Double> singleBalance = balance.get(paidBy);
            String paidTo = split.getUser().getUserName();
            System.out.println(paidBy+" "+paidTo+" "+split.getAmount());
            if(!singleBalance.containsKey(paidTo)) {
                singleBalance.put(paidTo,0.0);
            }

            singleBalance.put(paidTo,singleBalance.get(paidTo)+split.getAmount());

//            balance.put(paidBy,singleBalance);
//EXPENSE 1000 MOHIT 2 ROHIT JAIN EQUAL
            //EXPENSE 1000 ROHIT 1 JAIN EXACT 500 500

            singleBalance = balance.get(paidTo);
            if(!singleBalance.containsKey(paidBy)) {
                singleBalance.put(paidBy,0.0);
            }
            singleBalance.put(paidBy,singleBalance.get(paidBy)-split.getAmount());

//            balance.put(paidTo,singleBalance);
        }
    }
//EXPENSE 1000 MOHIT 2 ROHIT JAIN EQUAL
    public void showAllBalance() {
        for(User user :users) {

                Map<String,Double> temp = balance.get(user.getUserName());

            if(temp==null) continue;
//            System.out.println("HERE");


            String userAnother = (String) temp.keySet().toArray()[0];
//            System.out.println(userAnother);
                double balance = temp.get(userAnother);
                if(balance<0) {
                    balance = balance*-1;
                    System.out.println(user.getUserName()+" owes "+userAnother+" Rs"+balance);
                } else if(balance>0) {
                    System.out.println(userAnother+" owes "+user.getUserName());
                }

        }

    }

    public void showUserBalance(User forUser) {
        for(User user :users) {

            Map<String, Double> temp = balance.get(user.getUserName());

            if (temp == null) continue;
//            System.out.println("HERE");


            String userAnother = (String) temp.keySet().toArray()[0];
//            System.out.println(userAnother);
            if(user.getUserName().equals(forUser.getUserName())||userAnother.equals(forUser.getUserName())) {
                double balance = temp.get(userAnother);
                if (balance < 0) {
                    balance = balance * -1;
                    System.out.println(user.getUserName() + " owes " + userAnother + " Rs" + balance);
                } else if (balance > 0) {
                    System.out.println(userAnother + " owes " + user.getUserName());
                }

            }

        }

    }
}
