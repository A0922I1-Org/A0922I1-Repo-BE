package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.dto.report.Report;
import com.example.a0922i1projectmobilephone.entity.ManagerPurchaseHistory;
import com.example.a0922i1projectmobilephone.entity.OutputInvoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OutputInvoiceRepository extends JpaRepository<OutputInvoice, Integer> {

    @Query(value = "select count(*) from output_invoice o where o.output_invoice_day >=:fromDay and o.output_invoice_day<=:toDay", nativeQuery = true)
    long CountAll(@Param("fromDay") String fromDay, @Param("toDay") String toDay);

    @Query(value = "select count(*) from (select p.product_id,p.product_name,p.cost,o.output_invoice_day,id.amount,id.input_invoice_cost from output_invoice o join output_invoice_detail od on o.output_invoice_id = od.output_invoice_id join product p on p.product_id = od.product_id join input_invoice_detail id on id.product_id = p.product_id where o.output_invoice_day >=:fromDay and o.output_invoice_day<=:toDay and p.product_id = :productId) as report", nativeQuery = true)
    long CountByID(@Param("fromDay") String fromDay, @Param("toDay") String toDay, @Param("productId") Integer id);


    @Query(value = "select p.product_id,p.product_name,p.cost,o.output_invoice_day,id.amount,id.input_invoice_cost from output_invoice o join output_invoice_detail od on o.output_invoice_id = od.output_invoice_id join product p on p.product_id = od.product_id join input_invoice_detail id on id.product_id = p.product_id where o.output_invoice_day >=:fromDay and o.output_invoice_day<=:toDay",nativeQuery = true)
    List<Report>findByDay(@Param("fromDay")String fromDay,@Param("toDay")String toDay);


    @Query(value = "select p.product_id,p.product_name,p.cost,o.output_invoice_day,id.amount,id.input_invoice_cost from output_invoice o join output_invoice_detail od on o.output_invoice_id = od.output_invoice_id join product p on p.product_id = od.product_id join input_invoice_detail id on id.product_id = p.product_id where o.output_invoice_day >=:fromDay and o.output_invoice_day<=:toDay and p.product_id=:productId",nativeQuery = true)
    List<Report>findByDayAndProductId(@Param("fromDay")String fromDay,@Param("toDay")String toDay,@Param("productId")Integer id);


    // thuận

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
            "FROM output_invoice AS o \n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id \n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id \n" +
            "JOIN product AS p ON p.product_id = od.product_id \n" +
            "GROUP BY o.output_invoice_id\t\n" +
            "ORDER BY p.product_name ASC,od.quantity ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByProduct_name(Pageable pageable);
    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.product_name ) SEPARATOR ', ') AS productName\n" +
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
