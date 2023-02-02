package com.example.museumApp.controller;


import com.example.museumApp.dto.OrderDTO;
import com.example.museumApp.dto.ResponseOrderDTO;
import com.example.museumApp.model.*;
import com.example.museumApp.repository.MuseumRepository;
import com.example.museumApp.service.*;
import com.example.museumApp.util.DateUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Random;

@Controller
@RequestMapping("/tickets")
public class ShoppingCartController {

    private MuseumOrder.MuseumOrderService museumOrderService;
    private CustomerService customerService;
    private MuseumRepository museumRepository;
    private OrderDTO orderDTO;
    private MuseumService museumService;
    private ShoppingCartService shoppingCartService;



    public ShoppingCartController(MuseumOrder.MuseumOrderService museumOrderService, CustomerService customerService,
                                  MuseumRepository museumRepository, MuseumService museumService, ShoppingCartService shoppingCartService) {
        this.museumOrderService = museumOrderService;
        this.customerService = customerService;
        this.museumRepository = museumRepository;
        this.museumService = museumService;
        this.shoppingCartService = shoppingCartService;
    }
    @GetMapping
    public ModelAndView get(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("tickets");

        Museum museum = museumService.findById(id);

        modelAndView.addObject("museum", museum);

        return modelAndView;
    }

//    @GetMapping(value = "/getOrder/{orderId}")
//    public ResponseEntity<MuseumOrder>getOrderDetails(@PathVariable int orderId){
//
//        MuseumOrder museumOrder = museumOrderService.getOrderDetails(orderId);
//
//        return ResponseEntity.ok(museumOrder);
//    }

    @GetMapping("/add")
    public ModelAndView add()  {
        ModelAndView modelAndView = new ModelAndView("tickets");

        ShoppingCart shoppingCart = shoppingCartService.findById(0L);

        modelAndView.addObject("museum", shoppingCart);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(@Valid @ModelAttribute Museum museum, BindingResult result, ShoppingCart ticket) {
        ModelAndView modelAndView = new ModelAndView();

        if(result.hasErrors()) {
            modelAndView.setViewName("tickets");
        }
        else {
            modelAndView.setViewName("tickets");

            modelAndView.addObject("addTicketSuccess", true);
            modelAndView.addObject("addMuseumName", museum.getName());
            modelAndView.addObject("addMuseumLocation", museum.getLocation());
            modelAndView.addObject("addTicketNumber", museum.getAvailableQuantity());

            modelAndView.addObject("tickets", ticket);
        }
        return modelAndView;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseOrderDTO> placeOrder(){
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        float amount = museumOrderService.getCartAmount(orderDTO.getCartList());

        Customer customer = new Customer(orderDTO.getCustomerName(), orderDTO.getCustomerEmail());
        Long customerIdFromDb = customerService.isCustomerPresent(customer); //this may need adjusting

        if (customerIdFromDb !=null) {
            customer.setId(customerIdFromDb);
        }
        else {
            customer = customerService.saveCustomer(customer);
            }
        MuseumOrder museumOrder = new MuseumOrder(orderDTO.getOrderDescription(), customer, orderDTO.getCartList());
        museumOrder = museumOrderService.saveOrder(museumOrder);

        responseOrderDTO.setAmount(amount);
        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
        responseOrderDTO.setOrderId(museumOrder.getId());
        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

        return ResponseEntity.ok(responseOrderDTO);
        }

    }

