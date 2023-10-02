package com.example.a0922i1projectmobilephone.service.impl;

import com.example.a0922i1projectmobilephone.entity.Customer;
import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.repository.IRepositoryProduct;
import com.example.a0922i1projectmobilephone.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IRepositoryProduct iRepositoryProduct;
    @Override
    public Page<Product> getAllProduct(int page) {
        return iRepositoryProduct.getAllProducts(Pageable.ofSize(8).withPage(page));
    }
}
