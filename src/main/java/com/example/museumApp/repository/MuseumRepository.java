package com.example.museumApp.repository;

import com.example.museumApp.model.Museum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuseumRepository extends JpaRepository<Museum,Long> {
}
