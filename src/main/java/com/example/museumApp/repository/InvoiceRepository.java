package com.example.museumApp.repository;

import com.example.museumApp.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>
{

    @Modifying
    @Query("delete from Invoice where customer.id =:id")
    void deleteByCustomerId(@Param("id") Long id);
}
