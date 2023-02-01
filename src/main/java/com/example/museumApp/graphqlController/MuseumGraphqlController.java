package com.example.museumApp.graphqlController;

import com.example.museumApp.model.Artist;
import com.example.museumApp.model.Museum;
import com.example.museumApp.service.MuseumService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;

@Controller
public class MuseumGraphqlController
{
    private final Comparator<Museum> COMPARATOR = Comparator.comparing(Museum::getName);
    private final MuseumService museumService;

    public MuseumGraphqlController(MuseumService museumService) {
        this.museumService = museumService;
    }

    @QueryMapping
    public List<Museum> museums()
    {
        return museumService.findAll();
    }

    @QueryMapping
    public Museum museumById(@Argument Long id)
    {
        Museum museum = museumService.findById(id);
        if (museum == null)
            throw new IllegalArgumentException("Museum by that id does not exist");
        return museum;
    }

    @QueryMapping
    public List<Museum> museumByName(@Argument String name)
    {
        List<Museum> museumsByThisName = museumService.findByName(name);
        if (museumsByThisName.isEmpty())
            throw new IllegalArgumentException("Museum by that name does not exist");
        museumsByThisName.sort(COMPARATOR);
        return museumsByThisName;
    }
}
