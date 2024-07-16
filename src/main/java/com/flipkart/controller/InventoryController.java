package com.flipkart.controller;

import com.flipkart.model.Product;
import com.flipkart.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/search/{productId}")
    public Product searchProduct(@PathVariable String productId) {
        return inventoryService.searchProduct(productId);
    }

    @GetMapping
    public Map<String, Product> getAllProducts() {
        return inventoryService.getInventory();
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody Product product) {
        inventoryService.createProduct(product);
        return "Product created successfully";
    }
}