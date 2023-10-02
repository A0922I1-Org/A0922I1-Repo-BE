package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.dto.InputInvoiceDetailListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class InputInvoiceDetailRepoImpl {
    @PersistenceContext
    private EntityManager em;

    public Page<InputInvoiceDetailListDto> search(String supplierName, String productName, Date startDate, Date endDate, Pageable pageable) {
        String sql_search = "SELECT i.inputInvoiceDate AS inputInvoiceDate," +
                " i_detail.amount AS amount, i_detail.inputInvoiceCost AS inputInvoiceCost," +
                " p.productName AS productName," +
                " s.supplierName AS supplierName" +
                " FROM InputInvoiceDetail i_detail" +
                " JOIN Product p ON i_detail.product.id = p.id" +
                " JOIN InputInvoice i ON i_detail.inputInvoice.id = i.id" +
                " JOIN Supplier s ON i.supplier.id = s.id" +
                " WHERE 1=1";
        if (!supplierName.isEmpty()){
            sql_search += " AND s.supplierName LIKE :supplierName";
        }
        if (!productName.isEmpty()){
            sql_search += " AND p.productName LIKE :productName";
        }
        if (startDate!=null){
            sql_search += " AND i.inputInvoiceDate >= :startDate";
        }
        if (endDate!=null){
            sql_search += " AND i.inputInvoiceDate <= :endDate";
        }
        Query query = em.createQuery(sql_search);
        if (!supplierName.isEmpty()) {
            query.setParameter("supplierName", "%" + supplierName + "%");
        }
        if (!productName.isEmpty()) {
            query.setParameter("productName", "%" + productName + "%");
        }
        if (startDate != null) {
            query.setParameter("startDate",startDate);
        }
        if (endDate !=null) {
            query.setParameter("endDate", endDate);
        }

        List<InputInvoiceDetailListDto> resultList = query.getResultList();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), resultList.size());
        Page<InputInvoiceDetailListDto> page = new PageImpl<>(resultList.subList(start, end), pageable, resultList.size());
        return page;
    }

    public void addInputInvoiceDetail(int inputInvoiceId){
        em.createNativeQuery("INSERT INTO mobilephone.input_invoice_detail(amount, input_invoice_cost, input_invoice_id, product_id)" +
                " VALUES (?1, ?2, ?3, ?4)")
                .setParameter()
                .setParameter()
                .setParameter(3, inputInvoiceId)
                .setParameter()
    }
}

