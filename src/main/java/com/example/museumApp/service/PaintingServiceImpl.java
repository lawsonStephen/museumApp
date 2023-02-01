package com.example.museumApp.service;

import com.example.museumApp.model.Painting;
import com.example.museumApp.repository.ArtistRepository;
import com.example.museumApp.repository.PaintingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("paintingService")
public class PaintingServiceImpl implements PaintingService {

        Logger logger = LoggerFactory.getLogger(PaintingServiceImpl.class);


        private final PaintingRepository paintingRepository;
//        private final ArtistRepository artistRepository;

    @Autowired
    public PaintingServiceImpl(PaintingRepository paintingRepository
//            , ArtistRepository artistRepository
    ){
        this.paintingRepository=paintingRepository;
//        this.artistRepository=artistRepository;
    }


        @Override
        public Painting save(Painting painting) {
        logger.info("Entering the save function");

        painting = paintingRepository.saveAndFlush(painting);

        logger.info("Exiting the save");
        return painting;
    }

        @Override
        public List<Painting> findAll()  {
        logger.info(" Entering findAll function");

        List<Painting> paintings = paintingRepository.findAll();

        return paintings;
    }

        @Override
        public Painting findById(Long id) {
        logger.info("Entering the findById function");

        Painting painting = null;
        Optional<Painting> optionalPainting = paintingRepository.findById(id);

        if (optionalPainting.isPresent()) {
            painting = optionalPainting.get();
        } else {
            painting = paintingRepository.getReferenceById(1L);
//            movie = new Movie();
//            movie.setTitle("Yellowstone");
//            movie.setIsbn("1111");
//            movie.setMovieType((movieTypeRepository.getReferenceById(1L)));
        }

        return painting;
    }

    @Override
    public List<Painting> findByName(String name) {
        return paintingRepository.findByName(name);
    }


}
