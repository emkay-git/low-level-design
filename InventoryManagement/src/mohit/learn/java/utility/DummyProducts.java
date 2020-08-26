package mohit.learn.java.utility;

import mohit.learn.java.models.Product;
import mohit.learn.java.models.ProductInventory;
import mohit.learn.java.services.InventoryService;
import mohit.learn.java.services.ProductService;

import java.util.Random;

public class DummyProducts {


    public static void generateProducts(InventoryService inventoryService, ProductService productService) {
        Random r = new Random();
        for(int i=0;i<10;i++) {
            String id = Integer.toString(i);
            Product product = new Product();
            product.setId(id);
            product.setName("PRODUCT_"+id);
            product.setPrice(r.nextInt(100));

            productService.addProduct(product);
            inventoryService.addInventory(id,r.nextInt(10));
        }
    }
}
