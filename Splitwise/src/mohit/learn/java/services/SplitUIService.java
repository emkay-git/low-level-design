package mohit.learn.java.services;

import mohit.learn.java.enums.ExpenseType;
import mohit.learn.java.models.Expense;
import mohit.learn.java.models.ExpenseMetadata;
import mohit.learn.java.models.Split;
import mohit.learn.java.models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SplitUIService {

    BufferedReader br;
    UserService userService;
    DisplayService displayService;
    ExpenseService expenseService;
    public SplitUIService(UserService userService) {
        displayService = new DisplayService(userService);
        expenseService = new ExpenseService();
        this.userService = userService;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void loadUI() throws IOException {

        while(true) {
            String input[] = br.readLine().split(" ");
            String inputType = input[0];
            switch (inputType) {

                case "EXPENSE": {
                    String userName = input[2];
                    User paidBy = userService.getUser(userName);
                    int count = Integer.parseInt(input[3]);
                    List<Split> splitList = new ArrayList<>();
                    for(int i=0;i<count;i++) {
                        Split sp = new Split(userService.getUser(input[4+i]),0);
                        splitList.add(sp);
                    }
                    splitList.add(new Split(userService.getUser(userName),0));

                    int nextIndex = 4+count;
                    ExpenseType expenseType = ExpenseType.valueOf(input[nextIndex]);

                    switch (expenseType) {
                        case EQUAL: {
                            for(int i=0;i<count;i++) {
                                splitList.get(i).setExpenseType(expenseType);
                            }
                            break;
                        }
                        case EXACT:{
                            for(int i=0;i<count;i++) {
                                splitList.get(i).setExpenseType(expenseType);
                                splitList.get(i).setAmount(Double.parseDouble(input[nextIndex+1+i]));
                            }
                            break;
                        }
                        case PERCENTAGE: {
                            for(int i=0;i<count;i++) {
                                splitList.get(i).setExpenseType(expenseType);
                                splitList.get(i).setPercentage(Double.parseDouble(input[4+count+i]));
                            }
                            break;
                        }

                        default:  throw new IllegalArgumentException(" Not found");
                    }
                    double amount = Double.parseDouble(input[1]);
                    Expense expense = expenseService.createExpense(paidBy,amount,splitList,new ExpenseMetadata("RUPEES"),expenseType);
                    expense = expenseService.distributeExpense(expense);
                    displayService.initExpense(expense);
                    break;
                }
                case "SHOW": {
                    displayService.showUserBalance(userService.getUser(input[1]));
                    break;
                }
                case "SHOWALL": {
                    displayService.showAllBalance();
                    break;
                }
                default: throw new IllegalArgumentException("Invalid input");
            }
        }
    }

}
