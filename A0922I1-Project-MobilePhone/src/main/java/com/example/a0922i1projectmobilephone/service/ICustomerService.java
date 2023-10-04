package com.example.a0922i1projectmobilephone.service;
import com.example.a0922i1projectmobilephone.entity.Customer;
import org.springframework.data.domain.Page;


public interface ICustomerService {
    void save(Customer customer);
    Page<Customer> listCustomers(int page, String option, String search, String numberPhone);
}



