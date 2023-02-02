package com.example.museumApp.service;

import com.example.museumApp.model.Sculpture;
import com.example.museumApp.repository.ArtistRepository;
import com.example.museumApp.repository.SculptureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("sculptureService")
public class SculptureServiceImpl implements SculptureService {
    Logger logger = LoggerFactory.getLogger(SculptureServiceImpl.class);


    private final SculptureRepository sculptureRepository;

    @Autowired
    public SculptureServiceImpl(SculptureRepository sculptureRepository){
        this.sculptureRepository=sculptureRepository;
    }


    @Override
    public Sculpture save(Sculpture sculpture) {
        logger.info("Entering the save function");

        sculpture = sculptureRepository.saveAndFlush(sculpture);

        logger.info("Exiting the save");
        return sculpture;
    }

    @Override
    public List<Sculpture> findAll()  {
        logger.info(" Entering findAll function");

        List<Sculpture> sculptures = sculptureRepository.findAll();

        return sculptures;
    }

    @Override
    public Sculpture findById(Long id) {
        logger.info("Entering the findById function");

        Sculpture sculpture = null;
        Optional<Sculpture> optionalSculpture = sculptureRepository.findById(id);

        if (optionalSculpture.isPresent()) {
            sculpture = optionalSculpture.get();
        } else {
            sculpture = sculptureRepository.getReferenceById(1L);
            sculpture.setId(null);
        }

        return sculpture;
    }

    @Override
    public List<Sculpture> findByAuthorId(Long id) {
        return sculptureRepository.findByAuthorId(id);
    }

    @Override
    public List<Sculpture> findByName(String name) {
        return sculptureRepository.findByName(name);
    }


}
