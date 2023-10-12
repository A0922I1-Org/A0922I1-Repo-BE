package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.entity.ManagerPurchaseHistory;
import org.springframework.data.domain.Page;

public interface Output_invoiceService {
    Page<ManagerPurchaseHistory> getAll(int pageNo, int pageSize);
    Page<ManagerPurchaseHistory> sortByTotalPrice(int pageNo, int pageSize);
    Page<ManagerPurchaseHistory> sortByCustomerName(int pageNo, int pageSize);
    Page<ManagerPurchaseHistory> sortByProductName(int pageNo, int pageSize);
    Page<ManagerPurchaseHistory> sortByDateOutputInvoice(int pageNo, int pageSize);
    Page<ManagerPurchaseHistory> sortByQuantity(int pageNo, int pageSize);


}
