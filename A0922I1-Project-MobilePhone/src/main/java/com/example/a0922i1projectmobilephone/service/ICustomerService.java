package com.example.a0922i1projectmobilephone.service;
import com.example.a0922i1projectmobilephone.entity.Customer;
import org.springframework.data.domain.Page;


public interface ICustomerService {
    Page<Customer> getAllCustomers(int page);
    void save(Customer customer);
    Page<Customer> searchCustomer(int page, String option, String string, String numberPhone);
}



