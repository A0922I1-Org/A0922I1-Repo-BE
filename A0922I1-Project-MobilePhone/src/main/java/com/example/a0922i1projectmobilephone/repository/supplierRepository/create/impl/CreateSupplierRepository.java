package com.example.a0922i1projectmobilephone.repository.supplierRepository.create.impl;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CreateSupplierRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public void addNewSupplier(String address, String email, String name, String phone){
            entityManager.createNativeQuery("insert into supplier(supplier_address,supplier_email,supplier_name,supplier_phone)" +
                    "VALUES(?, ?, ?, ?)")
                    .setParameter(1, address)
                    .setParameter(2, email)
                    .setParameter(3,name)
                    .setParameter(4, phone)
                    .executeUpdate();
    }

}
