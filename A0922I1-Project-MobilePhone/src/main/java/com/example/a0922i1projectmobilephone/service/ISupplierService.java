package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ISupplierService {
    Page<Supplier> findAll(int pageNo, int pageSize);
    Optional<Supplier> findById(int id);
    boolean deleteById(int id);
    boolean existsById(int id);
}
