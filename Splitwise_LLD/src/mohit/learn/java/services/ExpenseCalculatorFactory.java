package mohit.learn.java.services;

import mohit.learn.java.enums.ExpenseType;
import mohit.learn.java.impl.EqualExpenseCalculator;
import mohit.learn.java.impl.ExactExpenseCalculator;
import mohit.learn.java.impl.PercentageExpenseCalculator;
import mohit.learn.java.interfaces.ExpenseCalculator;

public class ExpenseCalculatorFactory {

    public static ExpenseCalculator getExpenseCalculator(ExpenseType expenseType) {
        switch(expenseType) {
            case EQUAL: {
                return new EqualExpenseCalculator();
            }
            case EXACT: {
                return new ExactExpenseCalculator();
            }
            case PERCENTAGE: {
                return new PercentageExpenseCalculator();
            }
            default: {
                /// not supported
            }
        }
        return null;
    }
}
