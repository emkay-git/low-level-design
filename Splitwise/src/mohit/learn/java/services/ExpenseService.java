package mohit.learn.java.services;

import mohit.learn.java.enums.ExpenseType;
import mohit.learn.java.impl.ExpenseCalculatorFactory;
import mohit.learn.java.interfaces.ExpenseCalculator;
import mohit.learn.java.models.Expense;
import mohit.learn.java.models.ExpenseMetadata;
import mohit.learn.java.models.Split;
import mohit.learn.java.models.User;

import java.util.List;

public class ExpenseService {

    ExpenseCalculatorFactory factory;
    ExpenseCalculator expenseCalculator;
    public ExpenseService() {
        factory = new ExpenseCalculatorFactory();
    }

    public Expense createExpense(User paidBy, double amountPaid, List<Split> distributionList,
                                 ExpenseMetadata expenseMetadata,ExpenseType expenseType) {
        return new Expense(paidBy,amountPaid,distributionList,expenseMetadata,expenseType);
    }

    public Expense distributeExpense(Expense expense) {
        ExpenseType expenseType = expense.getExpenseType();
        expenseCalculator = factory.getExpenseCalculator(expense.getExpenseType());
        List<Split> splitList = expenseCalculator.calculateExpense(expense.getAmountPaid(),expense.getDistribution());
        expense.setDistribution(splitList);
        return expense;
    }
}
