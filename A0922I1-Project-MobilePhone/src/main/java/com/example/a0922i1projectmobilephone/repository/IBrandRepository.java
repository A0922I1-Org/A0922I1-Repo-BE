package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBrandRepository extends JpaRepository<Brand, Integer>{
    @Query(value = "select * from brand;", nativeQuery = true)
    List<Brand> getAllBrand();
}
