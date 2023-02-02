package com.example.museumApp.repository;

import com.example.museumApp.model.Museum;
import com.example.museumApp.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaintingRepository extends JpaRepository<Painting,Long> {
    @Query("select p from Painting p where p.name like %:name%")
    List<Painting> findByName(@Param("name") String name);

    @Query("select p from Painting p where p.artist.id=:id")
    List<Painting> findByAuthorId(@Param("id") Long id);
}
