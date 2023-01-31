package com.example.museumApp.service;

import com.example.museumApp.model.Artist;

import java.util.List;

public interface ArtistService {
    Artist save(Artist artist);

    List<Artist> findAll();

    Artist findById(Long id);
}
