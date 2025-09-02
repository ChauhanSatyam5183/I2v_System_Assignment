package com.example.satyam_I2v_Assigment.Repository;

import com.example.satyam_I2v_Assigment.Modal.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Repository
public class ProductRepo {

    private HashMap<Integer, Product> productList = new HashMap<>();
    private static int i = 1;

    public ProductRepo() {
        // Preload 2 products
        Product p1 = new Product(i++, "Laptop", 60000.0, null, null);
        Product p2 = new Product(i++, "Mobile", 25000.0, null, null);

        productList.put(p1.getProductId(), p1);
        productList.put(p2.getProductId(), p2);
    }

    public Product add(Product p) {
        p.setProductId(i++);
        productList.put(p.getProductId(), p);
        return p;
    }

    public boolean checkProduct(int id) {
        return productList.containsKey(id);
    }

    public void delete(int id) {
        productList.remove(id);
    }

    public Product update(Product p) {
        productList.put(p.getProductId(), p);
        return p;
    }

    public Product getById(int id) {
        return productList.get(id);
    }

    public List<Product> getAll() {
        return new ArrayList<>(productList.values());
    }
}
