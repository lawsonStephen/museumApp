package com.example.museumApp.service;

import com.example.museumApp.model.Artist;
import com.example.museumApp.repository.ArtistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("artistService")
public class ArtistServiceImpl implements ArtistService {

    Logger logger = LoggerFactory.getLogger(ArtistServiceImpl.class);


    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository){
        this.artistRepository=artistRepository;
    }


    @Override
    public Artist save(Artist artist) {
        logger.info("Entering the save function");

        artist = artistRepository.saveAndFlush(artist);

        logger.info("Exiting the save");
        return artist;
    }

    @Override
    public List<Artist> findAll()  {
        logger.info("Entering findAll function");

        List<Artist> artists = artistRepository.findAll();

        return artists;
    }

    @Override
    public Artist findById(Long id) {
        logger.info("Entering the findById function");

        Artist artist = null;
        Optional<Artist> optionalArtist = artistRepository.findById(id);

        if (optionalArtist.isPresent()) {
            artist = optionalArtist.get();
        } else {
            artist = artistRepository.getReferenceById(1L);
//            movie = new Movie();
//            movie.setTitle("Yellowstone");
//            movie.setIsbn("1111");
//            movie.setMovieType((movieTypeRepository.getReferenceById(1L)));
        }

        return artist;
    }


}
