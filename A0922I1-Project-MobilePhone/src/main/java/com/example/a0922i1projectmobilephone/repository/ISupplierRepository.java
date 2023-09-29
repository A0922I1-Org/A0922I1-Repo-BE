package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {
    @Query(value = "SELECT * FROM supplier", nativeQuery = true)
    Page<Supplier> findAllSupplier(Pageable pageable);
}
