package com.flipkart.controller;

import com.flipkart.model.Product;
import com.flipkart.model.CartItem;
import com.flipkart.service.CartService;
import com.flipkart.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public String addToCart(@RequestParam String productId, @RequestParam int quantity) {
        Product product = inventoryService.searchProduct(productId);
        if (product == null) {
            return "Product not found";
        }
        if (inventoryService.updateInventory(productId, quantity)) {
            cartService.addToCart(product, quantity);
            return "Product added to cart";
        } else {
            return "Insufficient stock";
        }
    }

    @GetMapping
    public List<CartItem> getCart() {
        return cartService.getCart();
    }
}