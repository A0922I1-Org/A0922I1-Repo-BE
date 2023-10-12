package com.example.a0922i1projectmobilephone.repository.input_invoice;

import com.example.a0922i1projectmobilephone.dto.input_invoice.ProductInputDto;
import com.example.a0922i1projectmobilephone.entity.InputInvoiceDetail;
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

    public Page<InputInvoiceDetail> search(String supplierName, String productName, Date startDate, Date endDate, Pageable pageable) {
        String sql_search = "SELECT iid.inputInvoiceCost," +
                " iid.amount, " +
                " iid.product," +
                " iid.inputInvoice FROM InputInvoiceDetail iid" +
                " WHERE 1=1";
        if (!supplierName.isEmpty()){
            sql_search += " AND iid.inputInvoice.supplier.supplierName LIKE :supplierName";
        }
        if (!productName.isEmpty()){
            sql_search += " AND iid.product.productName LIKE :productName";
        }
        if (startDate!=null){
            sql_search += " AND iid.inputInvoice.inputInvoiceDate >= :startDate";
        }
        if (endDate!=null){
            sql_search += " AND i.inputInvoice.inputInvoiceDate <= :endDate";
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

        List<InputInvoiceDetail> resultList = query.getResultList();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), resultList.size());
        Page<InputInvoiceDetail> page = new PageImpl<>(resultList.subList(start, end), pageable, resultList.size());
        return page;
    }

    public int addInputInvoiceDetail(ProductInputDto dto, int inputInvoiceId){
        em.createNativeQuery("insert into input_invoice_detail(amount, input_invoice_cost,input_invoice_id,product_id)" +
                "values (?1, ?2, ?3, ?4)")
                .setParameter(1, dto.getQuantity())
                .setParameter(2, dto.getCostPrice())
                .setParameter(3, inputInvoiceId)
                .setParameter(4, dto.getProductId())
                .executeUpdate();
        return 0;
    }

}

