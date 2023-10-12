package com.example.a0922i1projectmobilephone.dto.input_invoice;


import java.util.Date;

public interface InputInvoiceDetailListDto {
    Date getInputInvoiceDate();
    String getProductName();
    String getSupplierName();
    Integer getAmount();
    Integer getInputInvoiceCost();
}
