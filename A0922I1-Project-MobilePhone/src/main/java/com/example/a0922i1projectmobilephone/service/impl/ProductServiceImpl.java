package com.example.a0922i1projectmobilephone.service.impl;

import com.example.a0922i1projectmobilephone.dto.ProductDto;
import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.repository.IProductRepository;
import com.example.a0922i1projectmobilephone.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Product findById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.createProduct(
                product.getProductName(),
                product.getSellingPrice(),
                product.getScreenSize(),
                product.getFontCamera(),
                product.getBackCamera(),
                product.getProductCpu(),
                product.getImageUrl(),
                product.getProductStorage(),
                product.getDescription(),
                product.getCategory().getCategoryId(),
                product.getBrand().getBrandId()
        );
    }


    @Override
    public void editProduct(Product product) {
        productRepository.editProduct(
                product.getProductName(),
                product.getSellingPrice(),
                product.getScreenSize(),
                product.getFontCamera(),
                product.getBackCamera(),
                product.getProductCpu(),
                product.getImageUrl(),
                product.getProductStorage(),
                product.getDescription(),
                product.getCategory().getCategoryId(),
                product.getBrand().getBrandId(),
                product.getProductId());
    }
}
