package com.example.a0922i1projectmobilephone.service;
import com.example.a0922i1projectmobilephone.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ICustomerService {
    void save(Customer customer);

    Customer findById(int id);
    Page<Customer> listCustomers(int page, String option, String search, String numberPhone);
}



