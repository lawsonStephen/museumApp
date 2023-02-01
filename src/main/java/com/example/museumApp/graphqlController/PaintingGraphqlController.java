package com.example.museumApp.graphqlController;

import com.example.museumApp.model.Artist;
import com.example.museumApp.model.Museum;

import com.example.museumApp.model.Painting;
import com.example.museumApp.service.PaintingService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;

@Controller
public class PaintingGraphqlController
{
    private final Comparator<Painting> COMPARATOR = Comparator.comparing(Painting::getName);
    private final PaintingService paintingService;

    public PaintingGraphqlController(PaintingService paintingService) {
        this.paintingService = paintingService;
    }


    @QueryMapping
    public List<Painting> paintings() {
        return paintingService.findAll();
    }

    @QueryMapping
    public Painting paintingById(@Argument Long id)
    {
        Painting painting = paintingService.findById(id);
        if (painting == null)
            throw new IllegalArgumentException("Painting by that id does not exist");
        return painting;
    }

    @QueryMapping
    public List<Painting> paintingByName(@Argument String name)
    {
        List<Painting> paintingsByThisName = paintingService.findByName(name);
        if (paintingsByThisName.isEmpty())
            throw new IllegalArgumentException("Painting by that name does not exist");
        paintingsByThisName.sort(COMPARATOR);
        return paintingsByThisName;
    }





}
