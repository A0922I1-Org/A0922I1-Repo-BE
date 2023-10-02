package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.dto.InputInvoiceDetailDto;
import com.example.a0922i1projectmobilephone.entity.InputInvoiceDetail;
import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.data.domain.Page;

public interface InputInvoiceDetailService {
    Page<InputInvoiceDetailDto> getInputInvoiceDetail(int pageNo, int pageSize);
    Page<InputInvoiceDetailDto> search(String supplierName, String productName, String startDate, String endDate, int pageNo, int pageSize);

}
