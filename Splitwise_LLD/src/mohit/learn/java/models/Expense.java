package mohit.learn.java.models;

import mohit.learn.java.enums.ExpenseType;

public class Expense {
    private User createdBy;
    private double amount;
    private User[] members;
    private ExpenseType expenseType;
    private double distribution[];


    public Expense(User createdBy, double amount, User[] members, ExpenseType expenseType, double distribution[]) {
        this.createdBy = createdBy;
        this.amount = amount;
        this.members = members;
        this.expenseType = expenseType;
        this.distribution = distribution;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User[] getMembers() {
        return members;
    }

    public void setMembers(User[] members) {
        this.members = members;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public double[] getDistribution() {
        return distribution;
    }

    public void setDistribution(double distribution[]) {
        this.distribution = distribution;
    }



}
