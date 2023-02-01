package com.example.museumApp.repository;

import com.example.museumApp.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
    @Query("select a from Artist a where a.name like %:name%")
    List<Artist> findByName(@Param("name") String name);
}
