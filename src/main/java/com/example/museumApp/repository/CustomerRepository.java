package com.example.museumApp.repository;


import com.example.museumApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer getCustomerByEmailAndName(String email, String name);

//    public Optional<Customer> getCustomerByNameAndPassword(String name, String password);

    @Query("select c from Customer c where c.password=:password")
    Optional<Customer> findByPassword(@Param("password") String password);


}
