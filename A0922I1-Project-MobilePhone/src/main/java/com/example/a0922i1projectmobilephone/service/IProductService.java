package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.entity.Customer;
import com.example.a0922i1projectmobilephone.entity.Product;
import org.springframework.data.domain.Page;

public interface IProductService {
    Page<Product> getAllProduct(int page);
}
