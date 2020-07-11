package mohit.learn.java.ui;

import mohit.learn.java.data.UserDataStore;
import mohit.learn.java.enums.ExpenseType;
import mohit.learn.java.models.Expense;
import mohit.learn.java.models.User;
import mohit.learn.java.services.DisplayService;
import mohit.learn.java.services.ExpenseService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplitwiseUI {

    private BufferedReader br;
    private static SplitwiseUI splitwiseUI;
    private  DisplayService displayService;
    private ExpenseService expenseService;
    private UserDataStore userDataStore;
    private SplitwiseUI() {
        br =  new BufferedReader(new InputStreamReader(System.in));
        displayService = new DisplayService();
        expenseService = new ExpenseService();
    }

    public static SplitwiseUI loadUI() {
       if(splitwiseUI==null) {

           splitwiseUI = new SplitwiseUI();
       }
       return splitwiseUI;
    }


    public void takeInput() throws Exception {
        userDataStore = UserDataStore.getUserDataStoreInstance();
        while(true) {

            String options[] = br.readLine().split(" ");
            String menu = options[0];
            switch(menu) {
                case "EXPENSE": {
                    generateExpense(options);
                    break;
                }
                case "SHOW-ALL": {
                    displayService.showAllBalance();
                    break;
                }
                case "SHOW": {
                    displayService.showBalanceForUser(userDataStore.getUserById(options[1]));
                    break;
                }
                default: {
                    throw new IOException();
                }
            }

        }
    }

    public void generateExpense(String options[]) throws Exception {
        User createdBy = userDataStore.getUserById(options[1]);
        double amount = Double.parseDouble(options[2]);
        int numberOfPeople = Integer.parseInt(options[3]);
        User people[] = new User[numberOfPeople];
        for(int i=0;i<people.length;i++) {
            people[i] = userDataStore.getUserById(options[i+3]);
        }
        String expenseType = options[3+numberOfPeople+1];
        System.out.println(expenseType);
        int offset = numberOfPeople+5;
        double distribution[] = new double[numberOfPeople];
        for(int i=0;i<people.length;i++) {
            System.out.println(options[offset+i]);
            distribution[i] = Double.parseDouble(options[offset+i]);
        }
        Expense expense = new Expense(createdBy,amount,people, ExpenseType.valueOf(expenseType),distribution);
        expenseService.calculateExpense(expense);
    }

    public void showAllBalance() {
        this.displayService.showAllBalance();
    }

    public void showBalanceForUser(User user) {
        this.displayService.showBalanceForUser(user);
    }

}
