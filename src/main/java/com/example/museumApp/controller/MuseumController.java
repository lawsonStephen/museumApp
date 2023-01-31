package com.example.museumApp.controller;

import com.example.museumApp.model.Museum;
import com.example.museumApp.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/museum")
public class MuseumController {

    private final MuseumService museumService;

    @Autowired
    public MuseumController(MuseumService museumService){
        this.museumService = museumService;
    }

    @GetMapping
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("museums");

        List<Museum> museums = museumService.
                findAll();

        modelAndView.addObject("museums", museums);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add()  {
        ModelAndView modelAndView = new ModelAndView("addMuseum");

        Museum museum = museumService.findById(0L);

        modelAndView.addObject("museum", museum);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {

        Museum museum = museumService.findById(id);

        List<Museum> museums = new ArrayList<>();
        museums.add(museum);

        ModelAndView modelAndView = new ModelAndView("museums");
        modelAndView.addObject("museums", museums);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(@Valid @ModelAttribute Museum museum, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();


        if(result.hasErrors()) {
            modelAndView.setViewName("addMuseum");
        }
        else {
            modelAndView.setViewName("addMuseum");

            modelAndView.addObject("addMuseumSuccess", true);
            modelAndView.addObject("addMuseumName", museum.getName());
            museumService.save(museum);

            modelAndView.addObject("museum", museum);
        }
        return modelAndView;

    }

    @GetMapping("/edit")
    public ModelAndView edit(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("addMuseum");

        Museum museum = museumService.findById(id);

        modelAndView.addObject("museum", museum);

        return modelAndView;
    }
}
