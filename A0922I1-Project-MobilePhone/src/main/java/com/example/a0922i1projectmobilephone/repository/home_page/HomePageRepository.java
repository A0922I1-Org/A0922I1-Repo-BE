package com.example.a0922i1projectmobilephone.repository.home_page;

import com.example.a0922i1projectmobilephone.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomePageRepository extends PagingAndSortingRepository<Product,Integer> {
Page<Product>findByProductNameLike(Pageable pageable, String productName);
}
