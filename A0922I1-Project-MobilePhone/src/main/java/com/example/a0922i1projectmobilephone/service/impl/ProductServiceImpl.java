package com.example.a0922i1projectmobilephone.service.impl;

import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.repository.IProductRepository;
import com.example.a0922i1projectmobilephone.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAllProducts(pageable);
    }

    @Override
    public Product findProductById(Integer productId) {
        return productRepository.findProductById(productId);
    }

    @Override
    public boolean deleteProductById(Integer productId) {
        productRepository.deleteProductById(productId);
        return true;
    }

    @Override
    public Page<Product> searchProducts(String brandName, String sellingPrice, String productName, Pageable pageable) {
        Double minPrice= null;
        Double maxPrice= null;
        if (Objects.equals(sellingPrice, "")) {
            if (Objects.equals(brandName, "")) {
                if (Objects.equals(productName, "")) {
                    return productRepository.findAllProducts(pageable);
                }
                else return productRepository.searchProductsByName(productName,pageable);
            } else if (Objects.equals(productName, "")) {
                return productRepository.searchProductsByBrand(brandName,pageable);
            }
            else return productRepository.searchProducts(brandName,productName, pageable);
        } else {
            String[] priceRange = sellingPrice.split("-");
            minPrice = Double.parseDouble(priceRange[0]);
            maxPrice = Double.parseDouble(priceRange[1]);
            if (Objects.equals(brandName, "")) {
                if (Objects.equals(productName, "")) {
                    return productRepository.searchProducts(minPrice,maxPrice, pageable);
                }
                else return productRepository.searchProducts(minPrice,maxPrice,productName, pageable);
            }
            else if (Objects.equals(productName, "")) {
                return productRepository.searchProducts(brandName,minPrice,maxPrice, pageable);
            }
        } return productRepository.searchProducts(brandName,minPrice,maxPrice,productName, pageable);
    }
}

