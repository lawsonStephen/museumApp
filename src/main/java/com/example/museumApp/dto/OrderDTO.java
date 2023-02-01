package com.example.museumApp.dto;


import com.example.museumApp.model.ShoppingCart;

import java.util.List;

public class OrderDTO {

    private static String orderDescription;
    private static List<ShoppingCart> cartList;
    private static String customerEmail;
    private static String customerName;

    public OrderDTO(String orderDescription, List<ShoppingCart> cartList, String customerEmail, String customerName){
        this.orderDescription = orderDescription;
        this.cartList = cartList;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
    }

    public static String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public static List<ShoppingCart> getCartList() {
        return cartList;
    }

    public void setCartList(List<ShoppingCart> cartList) {
        this.cartList = cartList;
    }

    public static String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public static String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDescription='" + orderDescription + '\'' +
                ", cartList=" + cartList +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
