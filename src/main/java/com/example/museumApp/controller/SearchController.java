package com.example.museumApp.controller;

import com.example.museumApp.model.Artist;
import com.example.museumApp.model.Museum;
import com.example.museumApp.model.Painting;
import com.example.museumApp.model.Sculpture;
import com.example.museumApp.service.ArtistService;
import com.example.museumApp.service.MuseumService;
import com.example.museumApp.service.PaintingService;
import com.example.museumApp.service.SculptureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private PaintingService paintingService;

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

    @GetMapping("searchPainting")
    public ModelAndView findPainting(@PathParam("name") String name)
    {
        ModelAndView model = new ModelAndView("paintings");
        List<Painting> paintings = paintingService.findByName(name);

        model.addObject("paintings", paintings);
        return model;
    }

    @GetMapping("exchange")
    public String exchangePage(@PathParam("museumName") String museumName)
    {
        return "exchanges";
    }

    @GetMapping("exchangeArtifact")
    public String exchangeArtifact(@PathParam("museumName") String museumName, @PathParam("sculptureId") Long sculptureId, Model model)
    {
        Museum museum = museumService.findByName(museumName).get(0);
        Sculpture sculpture = sculptureService.findById(sculptureId);
        sculpture.setMuseum(museum);
        sculptureService.save(sculpture);

        return "museums";
    }




}
