package com.example.a0922i1projectmobilephone.service.output_invoice;

public interface OutputInvoiceService {
  long countById(String fromDay , String toDay , Integer id);

  long countAll(String fromDay, String toDay);

 long calculateRevenueByProductId(String fromDate, String toDate, Integer productId);
 long calculateRevenue(String fromDate, String toDate);


}