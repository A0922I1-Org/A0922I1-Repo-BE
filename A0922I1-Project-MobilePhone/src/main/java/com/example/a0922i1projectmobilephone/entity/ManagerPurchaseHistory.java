package com.example.a0922i1projectmobilephone.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface ManagerPurchaseHistory {
    String getCustomerName();
    Double getTotalPrice();
    LocalDateTime getDateOutputInvoice();
    String getProductName();



}
