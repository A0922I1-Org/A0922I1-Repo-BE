package com.example.a0922i1projectmobilephone.repository.supplierRepository.update.impl;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UpdateSupplierRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public void updateSupplier(String address, String email, String name, String phone, int id){
        entityManager.createNativeQuery("UPDATE `mobilephone`.`supplier` SET `supplier_address` = ?, `supplier_email` = ?, `supplier_name` = ?, `supplier_phone` = ?" +
                        " WHERE (`supplier_id` = ?)")
                .setParameter(1, address)
                .setParameter(2, email)
                .setParameter(3,name)
                .setParameter(4, phone)
                .setParameter(5,id)
                .executeUpdate();
    }
}
