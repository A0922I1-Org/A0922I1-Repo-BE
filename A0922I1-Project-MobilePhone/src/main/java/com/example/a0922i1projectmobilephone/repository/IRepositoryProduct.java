package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.entity.Customer;
import com.example.a0922i1projectmobilephone.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryProduct extends JpaRepository<Product, Integer> {
    @Query(value = "select product_id, product_name, cost, screen_size, font_camera, back_camera, product_cpu, image_url, product_storage,description,  from product", nativeQuery = true)
    Page<Product> getAllProducts(Pageable pageable);
}
