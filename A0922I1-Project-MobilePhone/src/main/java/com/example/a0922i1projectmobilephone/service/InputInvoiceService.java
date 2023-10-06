package com.example.a0922i1projectmobilephone.service;
import com.example.a0922i1projectmobilephone.dto.SupplierIdDto;
import com.example.a0922i1projectmobilephone.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface InputInvoiceService {
int addNewInputInvoice(SupplierIdDto supplier);
}
