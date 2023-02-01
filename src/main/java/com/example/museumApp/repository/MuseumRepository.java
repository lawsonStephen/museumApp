package com.example.museumApp.repository;

import com.example.museumApp.model.Museum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MuseumRepository extends JpaRepository<Museum,Long> {
    @Query("select m from Museum m where m.name like %:name%")
    List<Museum> findByName(@Param("name") String name);
}
