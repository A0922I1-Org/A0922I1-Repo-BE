package com.example.a0922i1projectmobilephone.repository.output_invoice;

import com.example.a0922i1projectmobilephone.entity.OutputInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface OutputInvoiceRepository extends JpaRepository<OutputInvoice, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO output_invoice (payment_method, total_price, date_output_invoice, customer_id) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void saveOutputInvoice(
            String paymentMethod,
            Double totalPrice,
            LocalDateTime dateOutputInvoice,
            Integer customerId

    );

    @Modifying
    @Query(value = "UPDATE output_invoice SET total_price = :totalPrice WHERE output_invoice_id = :outputInvoiceId", nativeQuery = true)
    void updateTotalPrice(@Param("outputInvoiceId") Integer outputInvoiceId, @Param("totalPrice") Double totalPrice);

    @Query(value = "SELECT MAX(output_invoice_id) FROM output_invoice", nativeQuery = true)
    Integer getLastOutputInvoiceId();


}
