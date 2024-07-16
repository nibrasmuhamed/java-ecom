package com.flipkart.service;

import com.flipkart.model.CartItem;
import com.flipkart.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private List<CartItem> cart = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        cart.add(cartItem);
    }

    public List<CartItem> getCart() {
        return cart;
    }
}