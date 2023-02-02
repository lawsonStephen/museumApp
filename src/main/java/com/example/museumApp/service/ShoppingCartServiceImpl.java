package com.example.museumApp.service;

import com.example.museumApp.model.ShoppingCart;
import com.example.museumApp.repository.ShoppingCartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        logger.info("Entering the save function");

        shoppingCart = shoppingCartRepository.saveAndFlush(shoppingCart);

        logger.info("Exiting the save");
        return shoppingCart;
    }

//    @Override
//    public List<Artist> findAll()  {
//        logger.info("Entering findAll function");
//
//        List<ShoppingCart> shoppingCart = shoppingCartRepository.findAll();
//
//        return shoppingCart;
//    }

    @Override
    public ShoppingCart findById(Long id) {
        logger.info("Entering the findById function");

        ShoppingCart shoppingCart = null;
        Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById(id);

        if (optionalShoppingCart.isPresent()) {
            shoppingCart = optionalShoppingCart.get();
        } else {
            shoppingCart = shoppingCartRepository.getReferenceById(1L);
        }
        return shoppingCart;
    }

    @Override
    public ShoppingCart getTicketQuantity(int quantity) {

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.getQuantity();

        return shoppingCart;
    }



}