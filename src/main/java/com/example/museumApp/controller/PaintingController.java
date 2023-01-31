package com.example.museumApp.controller;

import com.example.museumApp.model.Artist;
import com.example.museumApp.model.Museum;
import com.example.museumApp.model.Painting;
import com.example.museumApp.repository.ArtistRepository;
import com.example.museumApp.repository.MuseumRepository;
import com.example.museumApp.service.PaintingService;
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
@RequestMapping("/painting")
public class PaintingController {
    private final PaintingService paintingService;

//    private final ArtistRepository artistRepository;

//    private final MuseumRepository museumRepository;

    @Autowired
    public PaintingController(PaintingService paintingService //ArtistRepository artistRepository, MuseumRepository museumRepository
                               ){
        this.paintingService = paintingService;
//        this.artistRepository = artistRepository;
//        this.museumRepository = museumRepository;
    }

//    @ModelAttribute("artistList")
//    public List<Artist> getArtistList(){
//        return artistRepository.findAll();
//    }

//    @ModelAttribute("museumList")
//    public List<Museum> getMuseumList(){
//        return museumRepository.findAll();
//    }

    @GetMapping
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("paintings");

        List<Painting> paintings = paintingService.
                findAll();

        modelAndView.addObject("paintings", paintings);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add()  {
        ModelAndView modelAndView = new ModelAndView("addPainting");

        Painting painting = paintingService.findById(0L);

        modelAndView.addObject("painting", painting);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {

        Painting artist = paintingService.findById(id);

        List<Painting> paintings = new ArrayList<>();
        paintings.add(artist);

        ModelAndView modelAndView = new ModelAndView("paintings");
        modelAndView.addObject("paintings", paintings);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(@Valid @ModelAttribute Painting painting, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();


        if(result.hasErrors()) {
            modelAndView.setViewName("addPainting");
        }
        else {
            modelAndView.setViewName("addPainting");

            modelAndView.addObject("addPaintingSuccess", true);
            modelAndView.addObject("addPaintingName", painting.getName());
            paintingService.save(painting);

            modelAndView.addObject("painting", painting);
        }
        return modelAndView;

    }

    @GetMapping("/edit")
    public ModelAndView edit(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("addPainting");

        Painting painting = paintingService.findById(id);

        modelAndView.addObject("painting", painting);

        return modelAndView;
    }
}

