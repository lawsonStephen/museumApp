package com.example.museumApp.service;

import com.example.museumApp.model.Painting;

import java.util.List;

public interface PaintingService {
    Painting save(Painting painting);

    List<Painting> findAll();

    Painting findById(Long id);

    List<Painting> findByName(String name);

    List<Painting> findByAuthorId(Long id);
}
