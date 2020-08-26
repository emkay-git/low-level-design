package mohit.learn.java;

import mohit.learn.java.services.*;
import mohit.learn.java.utility.DummyProducts;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ProductService ps = new ProductService();
        InventoryService is = new InventoryService(ps);
        DummyProducts.generateProducts(is,ps);
        PaymentService paymentService = new PaymentService();
        UserInterfaceService uif = new UserInterfaceService(ps,is,new OrderService(ps,is,paymentService));
        uif.takeInput();
//        is.listInventory();
    }
}
