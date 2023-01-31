package com.example.museumApp.repository;

import com.example.museumApp.model.Sculpture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SculptureRepository extends JpaRepository<Sculpture, Long> {
}
