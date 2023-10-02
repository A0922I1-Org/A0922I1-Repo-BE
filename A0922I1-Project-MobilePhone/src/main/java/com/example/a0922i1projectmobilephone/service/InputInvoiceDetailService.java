package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.dto.InputInvoiceDetailListDto;
import org.springframework.data.domain.Page;

public interface InputInvoiceDetailService {
    Page<InputInvoiceDetailListDto> getInputInvoiceDetail(int pageNo, int pageSize);
    Page<InputInvoiceDetailListDto> search(String supplierName, String productName, String startDate, String endDate, int pageNo, int pageSize);
    void addInputInvoiceDetail();
}
