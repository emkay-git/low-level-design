package mohit.learn.java.model;

public class Bill {

    private String invoiceId;
    private int totalHourSpend;
    private double totalAmount;

    public Bill(String invoiceId, int totalHourSpend, double totalAmount) {
        this.invoiceId = invoiceId;
        this.totalHourSpend = totalHourSpend;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getTotalHourSpend() {
        return totalHourSpend;
    }

    public void setTotalHourSpend(int totalHourSpend) {
        this.totalHourSpend = totalHourSpend;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
