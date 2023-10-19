package com.example.a0922i1projectmobilephone.service.product;

import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iRepositoryProduct;

    @Override
    public Product findProductById(Integer productId) {
        return iRepositoryProduct.findProductById(productId);
    }

    @Override
    public boolean deleteProductById(Integer productId) {
        iRepositoryProduct.deleteProductById(productId);
        return true;
    }

    @Override
    public Page<Product> getProductList(String brandName, String sellingPrice, String productName, String productCpu, Pageable pageable) {
        Double minPrice = null;
        Double maxPrice = null;
        if (brandName == null && sellingPrice == null && productName == null && productCpu == null) {
            return iRepositoryProduct.findAllProducts(pageable);
        } else {
            if (sellingPrice == null) {
                return iRepositoryProduct.searchProducts(brandName, productName, productCpu, pageable);
            } else {
                String[] priceRange = sellingPrice.split("-");
                minPrice = Double.parseDouble(priceRange[0]);
                maxPrice = Double.parseDouble(priceRange[1]);
                return iRepositoryProduct.searchProducts(brandName, minPrice, maxPrice, productName, productCpu, pageable);
            }
        }
    }
}
