package mohit.learn.java.services;

import mohit.learn.java.interfaces.ExpenseCalculator;
import mohit.learn.java.models.Expense;

public class ExpenseService {
    private ExpenseCalculator expenseCalculator;

    public boolean calculateExpense(Expense expense) throws Exception {
        expenseCalculator = ExpenseCalculatorFactory.getExpenseCalculator(expense.getExpenseType());
        double distributedAmount [] = expenseCalculator.calculate(expense.getAmount(),expense.getDistribution());

        for(int i=0;i<expense.getMembers().length;i++) {
            expense.getCreatedBy().updateBalance(expense.getMembers()[i], distributedAmount[i]);
            expense.getMembers()[i].updateBalance(expense.getCreatedBy(), distributedAmount[i]);
        }

        return true;
    }


}
