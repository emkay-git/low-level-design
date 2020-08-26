package mohit.learn.java.services;

import mohit.learn.java.models.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInterfaceService {

    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    ProductService productService;
    InventoryService inventoryService;
    OrderService orderService;

    public UserInterfaceService(ProductService productService, InventoryService inventoryService, OrderService orderService) {
        this.productService = productService;
        this.inventoryService = inventoryService;
        this.orderService = orderService;
    }

    public void takeInput() {
        System.out.println("Following options are available\n" +
                "1. LIST - list all the items available and their quantity\n" +
                "2. ORDER <product_id> <quantity> - Order the given product if possible\n" +
                "3. CANCEL <order_id> - Cancel the order");
        while(true) {
            try {
                String userInput[] = br.readLine().split(" ");
                String option = userInput[0];
                switch (option) {
                    case "LIST": {
                        this.inventoryService.listInventory();
                        break;
                    }
                    case "ORDER": {
                        this.orderService.createOrder(userInput[1],Integer.parseInt(userInput[2]));
                        break;
                    }
                    case "CANCEL": {
                        this.orderService.cancelOrder(userInput[1]);
                        break;
                    }
                    default: {
                        System.out.println("Wrong option! Try again");
                    }
                }
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
