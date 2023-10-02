package com.example.a0922i1projectmobilephone.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;

@Repository
@Transactional
public class InputInvoiceRepoImpl {
    @PersistenceContext
    private EntityManager em;


   public void addNewInputInvoice(Date currentDate, Integer supplierId) {
        em.createNativeQuery("INSERT INTO input_invoice(input_invoice_date, supplier_id)" +
                                     "VALUES(?1, ?2)")
                .setParameter(1, currentDate)
                .setParameter(2, supplierId)
                .executeUpdate();

    }
}
