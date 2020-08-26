package mohit.learn.java.services;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    Map<String, Integer> productMap;
    ProductService productService;
    public InventoryService(ProductService ps) {
        this.productService = ps;
        productMap = new HashMap<>();
    }
    public void addInventory(String productId, int count) {
        productMap.put(productId, productMap.getOrDefault(productId,0)+count);
    }

    private boolean checkAvailability(String id, int quantity) {

        int inventory = productMap.get(id);

        if(quantity>inventory) return false;
        return true;
    }

    public boolean reserveProducts(String id, int quantity) {
        if(productMap.get(id)==null) throw new IllegalArgumentException("Product Not found");
        if(checkAvailability(id,quantity)) {
           productMap.put(id, productMap.get(id)-quantity);
           return true;
        }
        throw new IllegalArgumentException("Not enough inventory");
    }

    public void listInventory() {
        productMap.forEach((k,v) -> {
            System.out.println(this.productService.findProduct(k).toString()+" count="+v);
        });
    }

}
