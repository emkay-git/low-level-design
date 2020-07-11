package mohit.learn.java.impl;

import mohit.learn.java.interfaces.ExpenseCalculator;

public class PercentageExpenseCalculator implements ExpenseCalculator {

    @Override
    public double[] calculate(double amount, double[] distribution) {
        double newAmount[] = new double[distribution.length];
        for(int i=0;i<distribution.length;i++) {
            newAmount[i] = amount*distribution[i]/100;
        }
        return newAmount;
    }
}
