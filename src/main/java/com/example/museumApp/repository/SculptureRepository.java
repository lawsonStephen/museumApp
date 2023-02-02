package com.example.museumApp.repository;

import com.example.museumApp.model.Sculpture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SculptureRepository extends JpaRepository<Sculpture, Long> {
    @Query("select s from Sculpture s where s.artist.id=:id")
    List<Sculpture> findByAuthorId(@Param("id") Long id);

    @Query("select s from Sculpture s where s.name like %:name%")
    List<Sculpture> findByName(@Param("name") String name);

    @Query("select s from Sculpture s where s.artist.name like %:name%")
    List<Sculpture> findByArtistName(@Param("name")String name);
}
