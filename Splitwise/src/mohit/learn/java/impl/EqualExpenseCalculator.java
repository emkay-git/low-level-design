package mohit.learn.java.impl;

import mohit.learn.java.interfaces.ExpenseCalculator;
import mohit.learn.java.models.Split;

import java.util.List;

public class EqualExpenseCalculator implements ExpenseCalculator {


    @Override
    public List<Split> calculateExpense(double amount, List<Split> splitList) {
        if(splitList.size()==0) throw new IllegalArgumentException("Distribution List cannot be empty");
        double equalAmount = amount/splitList.size();
        for(Split split: splitList) {
            split.setAmount(equalAmount);
        }
        return splitList;
    }
}
