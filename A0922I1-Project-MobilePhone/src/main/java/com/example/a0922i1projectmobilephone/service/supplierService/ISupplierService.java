package com.example.a0922i1projectmobilephone.service.supplierService;

import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ISupplierService {
    Page<Supplier> findAll(int pageNo, int pageSize);
    Optional<Supplier> findById(int id);
    boolean deleteById(int id);
    boolean existsById(int id);

    Page<Supplier> sortBySupplierName(int flag, int pageNo, int pageSize);
    Page<Supplier> sortBySupplierId(int flag, int pageNo, int pageSize);
    Page<Supplier> searchSuppliers(String name, String address, String phone, int pageNo, int pageSize);

}