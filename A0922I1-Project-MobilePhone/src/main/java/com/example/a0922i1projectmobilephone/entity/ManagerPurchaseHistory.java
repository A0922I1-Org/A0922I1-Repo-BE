package com.example.a0922i1projectmobilephone.entity;

import java.time.LocalDateTime;

public interface ManagerPurchaseHistory {
    String getCustomerName();
    Double getTotalPrice();
    LocalDateTime getDateOutputInvoice();
    String getProductName();
}
