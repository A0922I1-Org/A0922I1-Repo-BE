package com.example.a0922i1projectmobilephone.service;
import com.example.a0922i1projectmobilephone.entity.Product;
import org.springframework.data.domain.Page;

public interface IProductService {
    Product findById(int id);
    Page<Product> listProduct(int page, String option, String search, String storage);

}
