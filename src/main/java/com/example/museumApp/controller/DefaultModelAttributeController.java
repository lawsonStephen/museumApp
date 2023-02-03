package com.example.museumApp.controller;

import com.example.museumApp.model.Customer;
import com.example.museumApp.model.Museum;
import com.example.museumApp.model.Sculpture;
import com.example.museumApp.service.MuseumService;
import com.example.museumApp.service.SculptureService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class DefaultModelAttributeController
{
    private final SculptureService sculptureService;
    private final MuseumService museumService;

    public DefaultModelAttributeController(SculptureService sculptureService, MuseumService museumService) {
        this.sculptureService = sculptureService;
        this.museumService = museumService;
    }

    @ModelAttribute("sculptures")
    public List<Sculpture> sculptureNames()
    {
        return sculptureService.findAll();

    }

    @ModelAttribute("museumNames")
    public List<String> museumNames()
    {
        return museumService.findAll()
                .stream()
                .map(Museum::getName)
                .collect(Collectors.toList());
    }

    @ModelAttribute("museums")
    public List<Museum> getAllMuseum()
    {
        return museumService.findAll();
    }

    @ModelAttribute("customer")
    public Customer activeCustomer()
    {
        return Customer.getCustomer();
    }
}
