package com.example.museumApp.controller;

import com.example.museumApp.model.Artist;
import com.example.museumApp.model.Museum;
import com.example.museumApp.model.Sculpture;
import com.example.museumApp.repository.ArtistRepository;
import com.example.museumApp.repository.MuseumRepository;
import com.example.museumApp.service.SculptureService;
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
@RequestMapping("/sculpture")
public class SculptureController {
    private final SculptureService sculptureService;

    private final ArtistRepository artistRepository;

    private final MuseumRepository museumRepository;

    @Autowired
    public SculptureController(SculptureService sculptureService, ArtistRepository artistRepository, MuseumRepository museumRepository){
        this.sculptureService = sculptureService;
        this.artistRepository = artistRepository;
        this.museumRepository = museumRepository;
    }

    @ModelAttribute("artistList")
    public List<Artist> getArtistList(){
        return artistRepository.findAll();
    }

    @ModelAttribute("museumList")
    public List<Museum> getMuseumList(){
        return museumRepository.findAll();
    }

    @GetMapping
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("sculptures");

        List<Sculpture> sculptures = sculptureService.
                findAll();

        modelAndView.addObject("sculptures", sculptures);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add()  {
        ModelAndView modelAndView = new ModelAndView("addSculpture");

        Sculpture sculpture = sculptureService.findById(0L);

        modelAndView.addObject("sculpture", sculpture);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {

        Sculpture artist = sculptureService.findById(id);

        List<Sculpture> sculptures = new ArrayList<>();
        sculptures.add(artist);

        ModelAndView modelAndView = new ModelAndView("sculptures");
        modelAndView.addObject("sculptures", sculptures);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(@Valid @ModelAttribute Sculpture sculpture, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();


        if(result.hasErrors()) {
            modelAndView.setViewName("addSculpture");
        }
        else {
            modelAndView.setViewName("addSculpture");

            modelAndView.addObject("addSculptureSuccess", true);
            modelAndView.addObject("addSculptureName", sculpture.getName());
            sculptureService.save(sculpture);

            modelAndView.addObject("sculpture", sculpture);
        }
        return modelAndView;

    }

    @GetMapping("/edit")
    public ModelAndView edit(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("addSculpture");

        Sculpture sculpture = sculptureService.findById(id);

        modelAndView.addObject("sculpture", sculpture);

        return modelAndView;
    }
}
