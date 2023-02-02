package com.example.museumApp.service;

import com.example.museumApp.model.Museum;
import com.example.museumApp.repository.MuseumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("museumService")
public class MuseumServiceImpl implements MuseumService {

    Logger logger = LoggerFactory.getLogger(MuseumServiceImpl.class);


    private final MuseumRepository museumRepository;

    @Autowired
    public MuseumServiceImpl(MuseumRepository museumRepository){
        this.museumRepository=museumRepository;
    }


    @Override
    public Museum save(Museum museum) {
        logger.info("Entering the save function");

        museum = museumRepository.saveAndFlush(museum);

        logger.info("Exiting the save");
        return museum;
    }

    @Override
    public List<Museum> findAll()  {
        logger.info("Entering findAll function");

        List<Museum> museums = museumRepository.findAll();

        return museums;
    }

    @Override
    public Museum findById(Long id) {
        logger.info("Entering the findById function");

        Museum museum = null;
        Optional<Museum> optionalMuseum = museumRepository.findById(id);

        if (optionalMuseum.isPresent()) {
            museum = optionalMuseum.get();
        } else {
            museum = museumRepository.getReferenceById(1L);
            museum.setId(null);
        }

        return museum;
    }

    @Override
    public List<Museum> findByName(String name) {
        return museumRepository.findByName(name);
    }




}

