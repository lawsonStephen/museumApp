package com.example.museumApp.service;


import com.example.museumApp.model.Museum;
import com.example.museumApp.repository.MuseumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {

    private MuseumRepository museumRepository;

    public ProductServiceImpl(MuseumRepository museumRepository){ //product service might be changed for museum repository
        this.museumRepository = museumRepository;
    }

    public List<Museum> getAllMuseums(){
        return this.museumRepository.findAll();
    }


}
