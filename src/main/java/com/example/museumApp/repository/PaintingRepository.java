package com.example.museumApp.repository;

import com.example.museumApp.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintingRepository extends JpaRepository<Painting,Long> {
}
