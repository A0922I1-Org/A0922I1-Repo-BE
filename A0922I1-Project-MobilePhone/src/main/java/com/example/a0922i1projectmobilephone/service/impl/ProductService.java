package com.example.a0922i1projectmobilephone.service.impl;
import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.repository.IRepositoryProduct;
import com.example.a0922i1projectmobilephone.service.IProductService;
import com.example.a0922i1projectmobilephone.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IRepositoryProduct iRepositoryProduct;

    @Override
    public Product findById(int id) {
        return iRepositoryProduct.findById(id);
    }

    @Override
    public Page<Product> listProduct(int page, String option, String search, String storage) {
        int isAll = 0;
        if (StringUtils.isEmpty(option) && StringUtils.isEmpty(storage)){
            isAll = 1;
        }
        if (StringUtils.isEmpty(storage)){
            storage = null;
        }
        return iRepositoryProduct.listProduct(Pageable.ofSize(8).withPage(page), option, search, storage, isAll);
    }

}
