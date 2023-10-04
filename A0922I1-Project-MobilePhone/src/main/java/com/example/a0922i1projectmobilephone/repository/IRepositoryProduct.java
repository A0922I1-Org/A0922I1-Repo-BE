package com.example.a0922i1projectmobilephone.repository;
import com.example.a0922i1projectmobilephone.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IRepositoryProduct extends JpaRepository<Product, Integer> {

    @Query(value = "")
    Page<Product> listProduct(Pageable pageable,
                              @Param("option") String option,
                              @Param("search") String search,
                              @Param("isAll") int isAll);
}
