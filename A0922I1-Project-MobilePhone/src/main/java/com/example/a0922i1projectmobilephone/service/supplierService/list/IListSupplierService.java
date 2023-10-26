package com.example.a0922i1projectmobilephone.service.supplierService.list;

import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IListSupplierService {
    Page<Supplier> findAll(int pageNo, int pageSize);
    Optional<Supplier> findById(int id);
    boolean deleteById(int id);
    boolean existsById(int id);

    Page<Supplier> sortBySupplierName(int flag, int pageNo, int pageSize);
    Page<Supplier> sortBySupplierId(int flag, int pageNo, int pageSize);
    Page<Supplier> searchSuppliers(String name, String address, String phone, int pageNo, int pageSize);
<<<<<<< HEAD:A0922I1-Project-MobilePhone/src/main/java/com/example/a0922i1projectmobilephone/service/supplierService/list/IListSupplierService.java



=======
    Page<Supplier> getSuppliers(String name, String address, String phone, Pageable pageable);
>>>>>>> main:A0922I1-Project-MobilePhone/src/main/java/com/example/a0922i1projectmobilephone/service/supplierService/ISupplierService.java
}