package com.example.museumApp.service;

import com.example.museumApp.model.Museum;

import java.util.List;

public interface MuseumService {
    Museum save(Museum museum);

    List<Museum> findAll();

    Museum findById(Long id);
}
