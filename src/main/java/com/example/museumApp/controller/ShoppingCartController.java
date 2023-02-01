package com.example.museumApp.controller;


import com.example.museumApp.dto.OrderDTO;
import com.example.museumApp.dto.ResponseOrderDTO;
import com.example.museumApp.model.Customer;
import com.example.museumApp.model.Museum;
import com.example.museumApp.model.MuseumOrder;
import com.example.museumApp.repository.MuseumRepository;
import com.example.museumApp.service.CustomerService;
import com.example.museumApp.util.DateUtil;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/api")
public class ShoppingCartController {
    private Long id;

    private MuseumOrder.MuseumOrderService museumOrderService;
    private CustomerService customerService;
    private MuseumRepository museumRepository;
    private OrderDTO orderDTO;

    private Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);


    public ShoppingCartController(MuseumOrder.MuseumOrderService museumOrderService, CustomerService customerService,
                                  MuseumRepository museumRepository) {
        this.museumOrderService = museumOrderService;
        this.customerService = customerService;
        this.museumRepository = museumRepository;
    }

    @GetMapping(value = "/getAllMuseums")
    public ResponseEntity<List<Museum>> findAll(){

        List<Museum> museums = museumRepository.findAll();

        return ResponseEntity.ok(museums);

    }

    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<MuseumOrder>getOrderDetails(@PathVariable int orderId){

        MuseumOrder museumOrder = museumOrderService.getOrderDetails(orderId);

        return ResponseEntity.ok(museumOrder);
    }

    @PostMapping("/placeOrder")
    @ResponseBody
    public ResponseEntity<ResponseOrderDTO> placeOrder(){
//        logger.info("Request  payload " + orderDTO);
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        float amount = museumOrderService.getCartAmount(orderDTO.getCartList());

        Customer customer = new Customer(orderDTO.getCustomerName(), orderDTO.getCustomerEmail());
        Long customerIdFromDb = customerService.isCustomerPresent(customer); //this may need adjusting

        if (customerIdFromDb !=null) {
            customer.setId(customerIdFromDb);
//            logger.info("Customer already present in db with id : " + customerIdFromDb);
        }
        else {
            customer = customerService.saveCustomer(customer);
//                logger.info("Customer saved with id : " + customer.getId());
            }
        MuseumOrder museumOrder = new MuseumOrder(orderDTO.getOrderDescription(), customer, orderDTO.getCartList());
        museumOrder = museumOrderService.saveOrder(museumOrder);
//        logger.info("Order processed successfully :) ");

        responseOrderDTO.setAmount(amount);
        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
        responseOrderDTO.setOrderId(museumOrder.getId());
        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

//        logger.info("Test push...");

        return ResponseEntity.ok(responseOrderDTO);

        }
    }

