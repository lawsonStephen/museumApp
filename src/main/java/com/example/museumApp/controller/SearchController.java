package com.example.museumApp.controller;

import com.example.museumApp.model.*;
import com.example.museumApp.service.WikiArtPaintingRetrieval;
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
    private SculptureService sculptureService;

    @Autowired
    private WikiArtPaintingRetrieval paintingRetrieval;

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

    @GetMapping("paintingsByArtist")
    public String paintingsByArtist(@PathParam("id") Long id, Model model)
    {
        Artist artist = artistService.findById(id);
        List<WikiArtPainting> paintings = paintingRetrieval.getPaintingsFor(artist);
        paintings = paintings.stream()
                .filter(x-> x.getArtistUrl().equals(artist.getArtistUrl()))
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("name", artist.getName());
        model.addAttribute("wikiPaintings", paintings);
        return "paintingsByArtistNew";

    }

    @GetMapping("searchArtist")
    public String searchArtistByName(@PathParam("name") String name, Model model)
    {
        List<Artist> artists = artistService.findByName(name);
        model.addAttribute("artists", artists);
        return "artists";
    }




}
