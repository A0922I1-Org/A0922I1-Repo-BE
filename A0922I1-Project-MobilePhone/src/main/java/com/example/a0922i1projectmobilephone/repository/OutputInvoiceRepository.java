package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.entity.ManagerPurchaseHistory;
import com.example.a0922i1projectmobilephone.entity.OutputInvoice;
import com.example.a0922i1projectmobilephone.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OutputInvoiceRepository extends JpaRepository<OutputInvoice, Integer> {
    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.product_name ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id ", nativeQuery = true)
    Page<ManagerPurchaseHistory> getAll(Pageable pageable);


    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.product_name ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id " +
            "ORDER BY customer_name ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByCustomerName(Pageable pageable);
    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.product_name ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id " +
            "ORDER BY product_name ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByProduct_name(Pageable pageable);
    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, SUM(od.quantity) AS quantity, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.product_name) SEPARATOR ', ') AS productName \n" +
            "FROM output_invoice AS o \n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id \n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id \n" +
            "JOIN product AS p ON p.product_id = od.product_id \n" +
            "GROUP BY o.output_invoice_id "+
            "ORDER BY quantity DESC ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByQuantity(Pageable pageable);
    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.product_name ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id " +
            "ORDER BY date_output_invoice ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByDateOutputInvoice(Pageable pageable);
    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.product_name ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id " +
            "ORDER BY total_price DESC ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByTotalPrice(Pageable pageable);


}