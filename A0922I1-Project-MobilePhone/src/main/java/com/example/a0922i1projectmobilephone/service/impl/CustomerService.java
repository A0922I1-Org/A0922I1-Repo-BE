package com.example.a0922i1projectmobilephone.service.impl;

import com.example.a0922i1projectmobilephone.entity.Customer;
import com.example.a0922i1projectmobilephone.repository.IRepositoryCustomer;
import com.example.a0922i1projectmobilephone.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private IRepositoryCustomer iRepositoryCustomer;
    @Override
    public Page<Customer> getAllCustomers(int page) {
        return iRepositoryCustomer.getAllCustomers(Pageable.ofSize(8).withPage(page));
    }
    @Override
    public void save(Customer customer) {
        iRepositoryCustomer.save(customer);
    }
    @Override
    public Page<Customer> searchCustomer(int page, String option, String string, String numberPhone) {
        if (option == null && string == null && numberPhone == null) {
            return iRepositoryCustomer.getAllCustomers(Pageable.ofSize(8).withPage(page));
        }
        return iRepositoryCustomer.searchCustomer(Pageable.ofSize(8).withPage(page), option, string, numberPhone);
    }
}

