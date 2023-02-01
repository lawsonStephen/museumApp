package com.example.museumApp.service;

import com.example.museumApp.model.Sculpture;

import java.util.List;

public interface SculptureService {
    Sculpture save(Sculpture sculpture);

    List<Sculpture> findAll();

    Sculpture findById(Long id);

    List<Sculpture> findByAuthorId(Long id);

    List<Sculpture> findByName(String name);
}
