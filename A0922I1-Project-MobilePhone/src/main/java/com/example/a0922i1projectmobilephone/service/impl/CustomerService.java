package com.example.a0922i1projectmobilephone.service.impl;
import com.example.a0922i1projectmobilephone.entity.Customer;
import com.example.a0922i1projectmobilephone.repository.IRepositoryCustomer;
import com.example.a0922i1projectmobilephone.service.ICustomerService;
import com.example.a0922i1projectmobilephone.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private IRepositoryCustomer iRepositoryCustomer;
    @Override
    public void save(Customer customer) {
        iRepositoryCustomer.save(customer);
    }

    @Override
    public Page<Customer> listCustomers(int page, String option, String search, String numberPhone) {
        int isAll = 0;
        if (StringUtils.isEmpty(option) && StringUtils.isEmpty(numberPhone) ) {
            isAll = 1;
        }
        return iRepositoryCustomer.searchCustomer(Pageable.ofSize(8).withPage(page), option, search, numberPhone, isAll);
    }


}

