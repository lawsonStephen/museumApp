package com.example.museumApp.controller;

import com.example.museumApp.model.Artist;
import com.example.museumApp.service.ArtistService;
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
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }

    @GetMapping
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("artists");

        List<Artist> artists = artistService.findAll();

        modelAndView.addObject("artists", artists);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add()  {
        ModelAndView modelAndView = new ModelAndView("addArtist");

        Artist artist = artistService.findById(0L);

        modelAndView.addObject("artist", artist);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {

        Artist artist = artistService.findById(id);

        List<Artist> artists = new ArrayList<>();
        artists.add(artist);

        ModelAndView modelAndView = new ModelAndView("artists");
        modelAndView.addObject("artists", artists);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(@Valid @ModelAttribute Artist artist, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();


        if(result.hasErrors()) {
            modelAndView.setViewName("addArtist");
        }
        else {
            modelAndView.setViewName("addArtist");

            modelAndView.addObject("addArtistSuccess", true);
            modelAndView.addObject("addArtistName", artist.getName());

            modelAndView.addObject("artist", artist);
            artistService.save(artist);


        }
        return modelAndView;

    }

    @GetMapping("/edit")
    public ModelAndView edit(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("addArtist");

        Artist artist = artistService.findById(id);

        modelAndView.addObject("artist", artist);

        return modelAndView;
    }
}
