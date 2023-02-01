package com.example.museumApp.repository;


import com.example.museumApp.model.MuseumOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumOrderRepository extends JpaRepository<MuseumOrder, Integer> {
}
