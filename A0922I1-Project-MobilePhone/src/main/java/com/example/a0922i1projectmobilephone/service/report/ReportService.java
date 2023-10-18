package com.example.a0922i1projectmobilephone.service.report;

public interface ReportService {
  long countById(String fromDay , String toDay , Integer id);

  long countAll(String fromDay, String toDay);

 long calculateRevenueByProductId(String fromDate, String toDate, Integer productId);
 long calculateRevenue(String fromDate, String toDate);


}
