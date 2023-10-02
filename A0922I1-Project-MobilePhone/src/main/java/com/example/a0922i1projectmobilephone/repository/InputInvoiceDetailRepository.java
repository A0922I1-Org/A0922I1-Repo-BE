package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.dto.InputInvoiceDetailDto;
import com.example.a0922i1projectmobilephone.entity.InputInvoiceDetail;
import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface InputInvoiceDetailRepository extends JpaRepository<InputInvoiceDetail, Integer> {
String sql_get_all ="SELECT i.input_invoice_date AS inputInvoiceDate," +
                  " i_detail.amount AS amount, i_detail.input_invoice_cost AS inputInvoiceCost," +
                  " p.name_product AS productName," +
                  " s.supplier_name AS supplierName" +
        " FROM input_invoice_detail i_detail" +
        " JOIN product p ON i_detail.product_id = p.product_id" +
        " JOIN input_invoice i ON i_detail.input_invoice_id = i.input_invoice_id" +
        " JOIN supplier s ON i.supplier_id = s.supplier_id";
    @Query(value = sql_get_all, nativeQuery = true)
    Page<InputInvoiceDetailDto> getInputInvoiceDetail(Pageable pageable);



}
