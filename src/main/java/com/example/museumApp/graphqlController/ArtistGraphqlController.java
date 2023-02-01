package com.example.museumApp.graphqlController;

import com.example.museumApp.model.Artist;
import com.example.museumApp.service.ArtistService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class ArtistGraphqlController
{
    private final Comparator<Artist> COMPARATOR = Comparator.comparing(Artist::getName);
    private final ArtistService artistService;

    public ArtistGraphqlController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @QueryMapping
    public List<Artist> artists()
    {
        return artistService.findAll();
    }
    @QueryMapping
    public Artist artistById(@Argument Long id)
    {
        Artist artist = artistService.findById(id);
        if (artist == null)
            throw new IllegalArgumentException("Artist by that id does not exist");
        return artist;
    }

    @QueryMapping
    public List<Artist> artistByName(@Argument String name)
    {
        List<Artist> artistsByThisName = artistService.findByName(name);
        if (artistsByThisName.isEmpty())
            throw new IllegalArgumentException("Artist by that id does not exist");
        artistsByThisName.sort(COMPARATOR);
        return artistsByThisName;
    }
}
