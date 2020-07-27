package mohit.learn.java.interfaces;

import mohit.learn.java.models.Split;

import java.util.List;

public interface ExpenseCalculator {

    List<Split> calculateExpense(double amount, List<Split> splitList);
}
