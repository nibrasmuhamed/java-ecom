package com.flipkart.service;

import com.flipkart.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InventoryService {
    private Map<String, Product> inventory = new HashMap<>();

    public InventoryService() {
        // I am loading some products
        inventory.put("1", new Product("1", "Laptop", 10));
        inventory.put("2", new Product("2", "Phone", 20));
    }

    public Product searchProduct(String productId) {
        return inventory.get(productId);
    }

    public boolean updateInventory(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null && product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            return true;
        }
        return false;
    }

    public void createProduct(Product product) {
        inventory.put(product.getId(), product);
    }

    public Map<String, Product> getInventory() {
        return inventory;
    }
}