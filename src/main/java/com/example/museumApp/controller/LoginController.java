package com.example.museumApp.controller;

import com.example.museumApp.model.Customer;
import com.example.museumApp.model.Museum;
import com.example.museumApp.repository.CustomerRepository;
import com.example.museumApp.repository.InvoiceRepository;
import com.example.museumApp.repository.MuseumRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.websocket.server.PathParam;
import java.util.Optional;

@Controller
public class LoginController
{

    private final CustomerRepository customerRepository;
    private final InvoiceRepository invoiceRepository;
    private final MuseumRepository museumRepository;

    public LoginController(CustomerRepository customerRepository, InvoiceRepository invoiceRepository, MuseumRepository museumRepository) {
        this.customerRepository = customerRepository;
        this.invoiceRepository = invoiceRepository;
        this.museumRepository = museumRepository;
    }

    @GetMapping("login")
    public String login(@ModelAttribute("museum") Museum museum, @PathParam("username") String name, @PathParam("password") String password, Model model)
    {
 ;
        museum = museumRepository.findById(museum.getId()).get();
        Optional<Customer> customerOptional = customerRepository.findByPassword(password);
        model.addAttribute("museum", museum);
        model.addAttribute("addMuseumName", museum.getName());
        model.addAttribute("addMuseumLocation", museum.getLocation());
        model.addAttribute("addTicketNumber", museum.getAvailableQuantity());

        if (customerOptional.isEmpty())
            return "login";
        else {
            Customer customer = new Customer();
            customer.setName(customerOptional.get().getName());
            customer.setId(customerOptional.get().getId());
            customer.setInvoices(customerOptional.get().getInvoices());
            customer.setAltId(customerOptional.get().getId());
            Customer.setCustomer(customer);

            return "tickets";
        }
    }

    @GetMapping("logout")
    public String logout()
    {
        Customer.setCustomer(null);
        return "museums";
    }


}
