package com.example.museumApp.service;

import com.example.museumApp.model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart save(ShoppingCart shoppingCart);

    ShoppingCart findById(Long id);

    ShoppingCart getTicketQuantity(int quantity);
}
