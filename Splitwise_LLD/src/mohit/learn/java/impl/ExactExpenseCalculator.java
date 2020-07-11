package mohit.learn.java.impl;

import mohit.learn.java.interfaces.ExpenseCalculator;

import java.util.concurrent.ExecutionException;

public class ExactExpenseCalculator implements ExpenseCalculator {
    @Override
    public double[] calculate(double amount, double[] distribution) throws Exception {
        double newAmount[] = new double[distribution.length];
        for(int i=0;i<distribution.length;i++) {
             newAmount[i] = distribution[i];
             amount-=distribution[i];
        }
        if(amount>0) throw new Exception();
        return newAmount;
    }
}
