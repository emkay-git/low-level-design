package mohit.learn.java.services;

import mohit.learn.java.enums.OrderStatus;
import mohit.learn.java.models.Order;

import java.util.HashMap;
import java.util.Map;

//Analogous to Booking
public class OrderService {

    ProductService productService;
    InventoryService inventoryService;
    PaymentService paymentService;

    Map<String, Order> orderMap;
    public OrderService(ProductService productService, InventoryService inventoryService, PaymentService paymentService) {
        this.productService = productService;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        orderMap = new HashMap<>();
    }

    public boolean createOrder(String id, int quantity) {
        if(!inventoryService.reserveProducts(id,quantity)) {
            throw new IllegalArgumentException("Inventory not sufficient");
        }

        Order order = new Order();
        order.setOrderId("order_"+orderMap.size());
        order.setProduct(productService.findProduct(id));
        order.setQuantity(quantity);
        order.setOrderStatus(OrderStatus.PENDING);
        order.setTotalPrice(order.getProduct().getPrice()*quantity);
        orderMap.put(order.getOrderId(),order);
        if(paymentService.doPayment()) {
            order.setOrderStatus(OrderStatus.CONFIRMED);
        }
        else {
            cancelOrder(order.getOrderId());
        }
        System.out.println(order.toString());
       return true;
    }

    public void cancelOrder(String orderId) {
        Order order = orderMap.get(orderId);
        order.setOrderStatus(OrderStatus.CANCELLED);
        inventoryService.addInventory(order.getProduct().getId(),order.getQuantity());
    }

}
