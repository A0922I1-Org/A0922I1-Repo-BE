package com.example.a0922i1projectmobilephone.repository.supplierRepository.update;

import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUpdateSupplierRepository  extends JpaRepository<Supplier,Integer> {
    @Query(value = "select * from `mobilephone`.`supplier` where supplier_id = ?", nativeQuery = true)
    Supplier findById(int supplierId);
}
