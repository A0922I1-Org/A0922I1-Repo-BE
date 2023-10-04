package com.example.a0922i1projectmobilephone.repository;

import org.springframework.data.jpa.repository.Query;
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


    public int addNewInputInvoice(Date currentDate, Integer supplierId) {
        if (
                em.createQuery("INSERT INTO InputInvoice(inputInvoiceDate, supplier) V ")
                        .setParameter(1, currentDate)
                        .setParameter(2, supplierId)
                        .executeUpdate() > 0
        ) {
            return getLastInsert();
        }
        return 0;
    }

    int getLastInsert() {
        return em.createNativeQuery("SELECT MAX(input_invoice_id) from input_invoice").getFirstResult();
    }
}
