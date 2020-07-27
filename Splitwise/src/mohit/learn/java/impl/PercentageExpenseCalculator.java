package mohit.learn.java.impl;

import mohit.learn.java.interfaces.ExpenseCalculator;
import mohit.learn.java.models.Split;

import java.util.List;

public class PercentageExpenseCalculator implements ExpenseCalculator {

    @Override
    public List<Split> calculateExpense(double amount, List<Split> splitList) {

        double totalPercentage = 0;
        for(Split split: splitList) {
            double percentage = split.getPercentage();
            totalPercentage+=percentage;
            double newAmount = percentage/100* amount;
            split.setAmount(newAmount);
        }

        if(Math.ceil(totalPercentage)!=100) throw new IllegalArgumentException("Percentage doesn't match");

        return splitList;

    }
}
