package com.example.museumApp.graphqlController;

import com.example.museumApp.graphqlInputModels.ExchangeInput;
import com.example.museumApp.model.Museum;
import com.example.museumApp.model.Sculpture;
import com.example.museumApp.service.MuseumService;
import com.example.museumApp.service.SculptureService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;

@Controller
public class SculptureGraphqlController
{
    private final Comparator<Sculpture> COMPARATOR = Comparator.comparing(Sculpture::getName);
    private final SculptureService sculptureService;
    private final MuseumService museumService;

    public SculptureGraphqlController(SculptureService sculptureService, MuseumService museumService) {
        this.sculptureService = sculptureService;
        this.museumService = museumService;
    }


    @QueryMapping
    public List<Sculpture> sculptures() {
        return sculptureService.findAll();
    }

    @QueryMapping
    public Sculpture sculptureById(@Argument Long id)
    {
        Sculpture sculpture = sculptureService.findById(id);
        if (sculpture == null)
            throw new IllegalArgumentException("sculpture by that id does not exist");
        return sculpture;
    }

    @QueryMapping
    public List<Sculpture> sculptureByName(@Argument String name) {
        List<Sculpture> sculpturesByThisName = sculptureService.findByName(name);
        if (sculpturesByThisName.isEmpty())
            throw new IllegalArgumentException("sculpture by that name does not exist");
        sculpturesByThisName.sort(COMPARATOR);
        return sculpturesByThisName;
    }

    @MutationMapping
    public Sculpture sendSculptureToMuseum(@Argument ExchangeInput exInput)
    {
        Museum museum = museumService.findByName(exInput.getMuseumName()).get(0);
        Sculpture sculpture = sculptureService.findByName(exInput.getSculptureName()).get(0);
        sculpture.setMuseum(museum);
        return sculptureService.save(sculpture);
    }
}
