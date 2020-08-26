package mohit.learn.java.services;

import mohit.learn.java.models.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductService {

    Set<Product> productSet = new HashSet<>();


    public boolean addProduct(Product p) {
        return productSet.add(p);
    }

    public Product findProduct(String id) {
        for (Product product : productSet) {
            if(product.getId().equals(id)) return product;
        }
        throw new IllegalArgumentException("Product not found");
    }

    public void listProducts() {
        for(Product product: productSet) {
            System.out.println(product.toString());
        }
    }
}
