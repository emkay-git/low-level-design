package mohit.learn.java.services;

public class PaymentService {

    int number;
    public PaymentService() {
        number = 0;
    }

    //Consider every 5th payments fail
    public boolean doPayment() {
        number+=1;
        if(number%3==0) return false;
        return true;
    }
}
