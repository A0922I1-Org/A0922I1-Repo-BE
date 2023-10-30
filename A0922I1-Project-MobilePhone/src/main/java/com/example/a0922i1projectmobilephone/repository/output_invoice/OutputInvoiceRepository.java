package com.example.a0922i1projectmobilephone.repository.output_invoice;

import com.example.a0922i1projectmobilephone.dto.report.Report;
import com.example.a0922i1projectmobilephone.entity.ManagerPurchaseHistory;
import com.example.a0922i1projectmobilephone.entity.OutputInvoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface OutputInvoiceRepository extends JpaRepository<OutputInvoice, Integer> {
    /**
     * NhanTP
     * Create Output Invoice
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO output_invoice (payment_method, total_price, date_output_invoice, customer_id) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void saveOutputInvoice(
            String paymentMethod,
            Integer totalPrice,
            LocalDateTime dateOutputInvoice,
            Integer customerId

    );
    /**
     * NhanTP
     * Update total price
     */
    @Modifying
    @Query(value = "UPDATE output_invoice SET total_price = :totalPrice WHERE output_invoice_id = :outputInvoiceId", nativeQuery = true)
    void updateTotalPrice(@Param("outputInvoiceId") Integer outputInvoiceId, @Param("totalPrice") Integer totalPrice);
    /**
     * NhanTP
     *Get last id Output Invoice
     */
    @Query(value = "SELECT MAX(output_invoice_id) FROM output_invoice", nativeQuery = true)
    Integer getLastOutputInvoiceId();

    @Query(value = "select count(*) from output_invoice o where o.date_output_invoice >=:fromDay and o.date_output_invoice<=:toDay", nativeQuery = true)
    long CountAll(@Param("fromDay") String fromDay, @Param("toDay") String toDay);

    @Query(value = "select count(*) from (select p.product_id,p.name_product,p.cost_product,p.selling_price_product,o.date_output_invoice from output_invoice o join output_invoice_detail od on o.output_invoice_id = od.output_invoice_id join product p on p.product_id = od.product_id  where o.date_output_invoice >=:fromDay and o.date_output_invoice<=:toDay and p.product_id = :productId) as report", nativeQuery = true)
    long CountByID(@Param("fromDay") String fromDay, @Param("toDay") String toDay, @Param("productId") Integer id);


    @Query(value = "select p.product_id,p.name_product,p.cost_product,p.selling_price_product,o.date_output_invoice from output_invoice o join output_invoice_detail od on o.output_invoice_id = od.output_invoice_id join product p on p.product_id = od.product_id  where o.date_output_invoice >=:fromDay and o.date_output_invoice<=:toDay",nativeQuery = true)
    List<Report>findByDay(@Param("fromDay")String fromDay,@Param("toDay")String toDay);


    @Query(value = "select p.product_id,p.name_product,p.cost_product,p.selling_price_product,o.date_output_invoice from output_invoice o join output_invoice_detail od on o.output_invoice_id = od.output_invoice_id join product p on p.product_id = od.product_id  where o.date_output_invoice >=:fromDay and o.date_output_invoice<=:toDay and p.product_id=:productId",nativeQuery = true)
    List<Report>findByDayAndProductId(@Param("fromDay")String fromDay,@Param("toDay")String toDay,@Param("productId")Integer id);


    // thuận

    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.name_product ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id", nativeQuery = true)
    Page<ManagerPurchaseHistory> getAll(Pageable pageable);


    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.name_product ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id " +
            "ORDER BY customer_name ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByCustomerName(Pageable pageable);
    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.name_product ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id " +
            "ORDER BY p.name_product ASC,od.quantity ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByProduct_name(Pageable pageable);
    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.name_product ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id "+
            "ORDER BY quantity DESC ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByQuantity(Pageable pageable);
    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.name_product ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id " +
            "ORDER BY date_output_invoice ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByDateOutputInvoice(Pageable pageable);


    @Query(value = "SELECT o.output_invoice_id as outputInvoiceId, c.customer_name as customerName, o.total_price as totalPrice, o.date_output_invoice as dateOutputInvoice, GROUP_CONCAT(CONCAT(od.quantity, ' ', p.name_product ) SEPARATOR ', ') AS productName\n" +
            "FROM output_invoice AS o\n" +
            "JOIN customer AS c ON c.customer_id = o.customer_id\n" +
            "JOIN output_invoice_detail AS od ON od.output_invoice_id = o.output_invoice_id\n" +
            "JOIN product AS p ON p.product_id = od.product_id\n" +
            "GROUP BY o.output_invoice_id " +
            "ORDER BY total_price DESC ", nativeQuery = true)
    Page<ManagerPurchaseHistory>sortByTotalPrice(Pageable pageable);
}
