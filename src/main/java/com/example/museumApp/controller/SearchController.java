package com.example.museumApp.controller;

import com.example.museumApp.model.Artist;
import com.example.museumApp.model.Museum;
import com.example.museumApp.model.Sculpture;
import com.example.museumApp.service.ArtistService;
import com.example.museumApp.service.MuseumService;
import com.example.museumApp.service.SculptureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchController
{
    @Autowired
    private MuseumService museumService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    SculptureService sculptureService;

    @GetMapping("searchMuseum")
    public ModelAndView findMuseum(@PathParam("name") String name)
    {
        ModelAndView model = new ModelAndView("museums");
        List<Museum> museums = museumService.findByName(name);

        model.addObject("museums", museums);
        return model;
    }

    @GetMapping("museumsByArtist")
    public ModelAndView findMuseumsByArtistId(@PathParam("id") Long id)
    {

        List<Sculpture> sculptures = sculptureService.findByAuthorId(id);
        List<Museum> museums = sculptures
            .stream()
            .map(Sculpture::getMuseum)
            .distinct()
            .collect(Collectors.toList());
        Artist artist = artistService.findById(id);

        ModelAndView model = new ModelAndView("museumsByArtist");
        model.addObject("artist", artist);
        model.addObject("museums",museums);
        return model;

    }

}
