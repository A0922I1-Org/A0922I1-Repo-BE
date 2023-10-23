package com.example.a0922i1projectmobilephone.service.output_invoice;

import com.example.a0922i1projectmobilephone.entity.ManagerPurchaseHistory;
import org.springframework.data.domain.Page;

public interface OutputInvoiceService {
  long countById(String fromDay , String toDay , Integer id);

  long countAll(String fromDay, String toDay);

 long calculateRevenueByProductId(String fromDate, String toDate, Integer productId);
 long calculateRevenue(String fromDate, String toDate);


 //thuận
 Page<ManagerPurchaseHistory> getAll(int pageNo, int pageSize);
    Page<ManagerPurchaseHistory> sortByTotalPrice(int pageNo, int pageSize);
    Page<ManagerPurchaseHistory> sortByCustomerName(int pageNo, int pageSize);
    Page<ManagerPurchaseHistory> sortByProductName(int pageNo, int pageSize);
    Page<ManagerPurchaseHistory> sortByDateOutputInvoice(int pageNo, int pageSize);
    Page<ManagerPurchaseHistory> sortByQuantity(int pageNo, int pageSize);
}
