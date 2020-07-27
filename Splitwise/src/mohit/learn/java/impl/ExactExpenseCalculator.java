package mohit.learn.java.impl;

import mohit.learn.java.interfaces.ExpenseCalculator;
import mohit.learn.java.models.Split;

import java.util.List;

public class ExactExpenseCalculator implements ExpenseCalculator {
    @Override
    public List<Split> calculateExpense(double amount, List<Split> splitList) {

       return splitList;
    }
}
