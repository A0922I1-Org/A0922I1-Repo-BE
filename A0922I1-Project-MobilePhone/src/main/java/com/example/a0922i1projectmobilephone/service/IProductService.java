package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.dto.ProductDto;
import com.example.a0922i1projectmobilephone.entity.Product;

public interface IProductService {
    Product findById(Integer id);

    void createProduct(Product product);
    void editProduct(Product product);


}
