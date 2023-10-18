package com.example.a0922i1projectmobilephone.repository.report;

import com.example.a0922i1projectmobilephone.dto.report.Report;
import com.example.a0922i1projectmobilephone.entity.OutputInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<OutputInvoice, Integer> {

    @Query(value = "select count(*) from output_invoice o where o.output_invoice_day >=:fromDay and o.output_invoice_day<=:toDay", nativeQuery = true)
    long CountAll(@Param("fromDay") String fromDay, @Param("toDay") String toDay);

    @Query(value = "select count(*) from (select p.product_id,p.product_name,p.cost,o.output_invoice_day,id.amount,id.input_invoice_cost from output_invoice o join output_invoice_detail od on o.output_invoice_id = od.output_invoice_id join product p on p.product_id = od.product_id join input_invoice_detail id on id.product_id = p.product_id where o.output_invoice_day >=:fromDay and o.output_invoice_day<=:toDay and p.product_id = :productId) as report", nativeQuery = true)
    long CountByID(@Param("fromDay") String fromDay, @Param("toDay") String toDay, @Param("productId") Integer id);


    @Query(value = "select p.product_id,p.product_name,p.cost,o.output_invoice_day,id.amount,id.input_invoice_cost from output_invoice o join output_invoice_detail od on o.output_invoice_id = od.output_invoice_id join product p on p.product_id = od.product_id join input_invoice_detail id on id.product_id = p.product_id where o.output_invoice_day >=:fromDay and o.output_invoice_day<=:toDay",nativeQuery = true)
    List<Report>findByDay(@Param("fromDay")String fromDay,@Param("toDay")String toDay);


    @Query(value = "select p.product_id,p.product_name,p.cost,o.output_invoice_day,id.amount,id.input_invoice_cost from output_invoice o join output_invoice_detail od on o.output_invoice_id = od.output_invoice_id join product p on p.product_id = od.product_id join input_invoice_detail id on id.product_id = p.product_id where o.output_invoice_day >=:fromDay and o.output_invoice_day<=:toDay and p.product_id=:productId",nativeQuery = true)
    List<Report>findByDayAndProductId(@Param("fromDay")String fromDay,@Param("toDay")String toDay,@Param("productId")Integer id);
}
