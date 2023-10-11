package com.example.a0922i1projectmobilephone.repository.supplierRepository.update;

<<<<<<< HEAD
import com.example.a0922i1projectmobilephone.controller.dto.SupplierDtoCreateUpdate;
import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
=======
import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
>>>>>>> NghiaBH-c-u-supplier

public interface IUpdateSupplierRepository  extends JpaRepository<Supplier,Integer> {
    @Query(value = "select * from `mobilephone`.`supplier` where supplier_id = ?", nativeQuery = true)
    Supplier findById(int supplierId);
}
