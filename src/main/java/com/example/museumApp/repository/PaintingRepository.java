package com.example.museumApp.repository;

import com.example.museumApp.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaintingRepository extends JpaRepository<Painting,Long> {
    @Query("select p from Painting p where p.name like %:name%")
    List<Painting> findByName(@Param("name") String name);
}
