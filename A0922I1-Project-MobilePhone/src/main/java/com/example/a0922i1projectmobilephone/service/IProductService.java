package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllProducts(Pageable pageable)
    Product findProductById (Integer productId);
    boolean deleteProductById (Integer productId);
    Page<Product> searchProducts (String brandName, String sellingPrice, String productName, Pageable pageable);
}
