package com.example.a0922i1projectmobilephone.repository.supplierRepository.create;

import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreateSupplierRepository extends JpaRepository<Supplier, Integer> {

}
