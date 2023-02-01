package com.example.museumApp.model;


import com.example.museumApp.repository.MuseumOrderRepository;
import com.example.museumApp.repository.MuseumRepository;
import com.example.museumApp.service.MuseumService;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "MUSEUM_ORDER")
public class MuseumOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderDescription;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ShoppingCart.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<ShoppingCart> cartList;

    public MuseumOrder(String orderDescription, Customer customer, List<ShoppingCart> cartList){
        this.orderDescription = orderDescription;
        this.customer = customer;
        this.cartList = cartList;
    }

    public MuseumOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ShoppingCart> getCartList() {
        return cartList;
    }

    public void setCartList(List<ShoppingCart> cartList) {
        this.cartList = cartList;
    }

    @Service
    public static class MuseumOrderService {

        private MuseumOrderRepository museumOrderRepository;
        private MuseumRepository museumRepository;
        private MuseumService museumService;

        public MuseumOrderService(MuseumOrderRepository museumOrderRepository, MuseumRepository museumRepository, MuseumService museumService){
            this.museumOrderRepository = museumOrderRepository;
            this.museumRepository = museumRepository;
            this.museumService = museumService;
        }

        public MuseumOrder getOrderDetails(int orderId){
            Optional<MuseumOrder> order = this.museumOrderRepository.findById(orderId);
            return order.isPresent() ? (MuseumOrder) order.get() : null;
        }

        public float getCartAmount(List<ShoppingCart> shoppingCartList){
            float totalCartAmount = 0f;
            float singleCartAmount = 0f;
            int availableQuantity = 0;

            for(ShoppingCart cart : shoppingCartList){

                Long productId = cart.getProductId();
                Optional<Museum> museum = Optional.ofNullable(museumService.findById(productId));
                if (museum.isPresent()){
                    Museum product1 = museum.get();
                    if (product1.getAvailableQuantity() < cart.getQuantity()){
                        singleCartAmount = product1.getPrice() * product1.getAvailableQuantity();
                        cart.setQuantity(product1.getAvailableQuantity());
                    }
                    else {
                        singleCartAmount = cart.getQuantity() * product1.getPrice();
                        availableQuantity = product1.getAvailableQuantity() - cart.getQuantity();
                    }
                    totalCartAmount = totalCartAmount + singleCartAmount;
                    product1.setAvailableQuantity(availableQuantity);
                    availableQuantity=0;
                    cart.setProductName(product1.getName());
                    cart.setAmount(singleCartAmount);
                    museumService.save(product1);
                }
            }
            return totalCartAmount;
        }

        public MuseumOrder saveOrder(MuseumOrder order){
            return museumOrderRepository.save(order);
        }

    }
}
