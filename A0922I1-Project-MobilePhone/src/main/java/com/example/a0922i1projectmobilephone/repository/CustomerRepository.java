package com.example.a0922i1projectmobilephone.repository;


import com.example.a0922i1projectmobilephone.dto.CustomerDTO;
import com.example.a0922i1projectmobilephone.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customer(customer_name, customer_phone, customer_address, customer_email) VALUES (:customerName, :phoneNumber, :address, :email)", nativeQuery = true)
    void saveCustomer(@Param("customerName") String customerName, @Param("phoneNumber") String phoneNumber, @Param("address") String address, @Param("email") String email);

    @Query("SELECT c.customerId AS customer_id, c.customerName AS customer_name, c.customerPhone AS customer_phone, c.customerAddress AS customer_address, c.customerEmail AS customer_email FROM Customer c WHERE c.customerId = :customerId")
    CustomerDTO findCustomerById(@Param("customerId") Integer customerId);

    @Query(value = "SELECT MAX(customer_id) FROM customer", nativeQuery = true)
    Integer getLastCustomerId();



}
