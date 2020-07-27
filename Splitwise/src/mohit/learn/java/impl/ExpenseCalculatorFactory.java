package mohit.learn.java.impl;

import mohit.learn.java.enums.ExpenseType;
import mohit.learn.java.interfaces.ExpenseCalculator;

public class ExpenseCalculatorFactory {

    public ExpenseCalculator getExpenseCalculator(ExpenseType expenseType) {
        switch (expenseType) {
            case EXACT: return new ExactExpenseCalculator();
            case EQUAL: return new EqualExpenseCalculator();
            case PERCENTAGE: return new PercentageExpenseCalculator();
            default: return null;
        }
    }
}
