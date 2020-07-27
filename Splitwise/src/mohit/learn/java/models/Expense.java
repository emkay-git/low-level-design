package mohit.learn.java.models;

import mohit.learn.java.enums.ExpenseType;

import java.util.List;

public class Expense {
    User paidBy;
    double amountPaid;
    List<Split> distribution;
    ExpenseType expenseType;
    ExpenseMetadata expenseMetadata;

    public Expense(User paidBy, double amountPaid, List<Split> distribution, ExpenseMetadata expenseMetadata,ExpenseType expenseType) {
        this.paidBy = paidBy;
        this.amountPaid = amountPaid;
        this.distribution = distribution;
        this.expenseMetadata = expenseMetadata;
        this.expenseType = expenseType;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public List<Split> getDistribution() {
        return distribution;
    }

    public void setDistribution(List<Split> distribution) {
        this.distribution = distribution;
    }

    public ExpenseMetadata getExpenseMetadata() {
        return expenseMetadata;
    }

    public void setExpenseMetadata(ExpenseMetadata expenseMetadata) {
        this.expenseMetadata = expenseMetadata;
    }
}
