package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.dto.InputInvoiceDto;
import com.example.a0922i1projectmobilephone.dto.SupplierIdDto;
import com.example.a0922i1projectmobilephone.entity.Supplier;
import com.example.a0922i1projectmobilephone.repository.InputInvoiceDetailRepoImpl;
import com.example.a0922i1projectmobilephone.repository.InputInvoiceRepoImpl;
import com.example.a0922i1projectmobilephone.repository.InputInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class InputInvoiceServiceImpl implements InputInvoiceService {
    @Autowired
    private InputInvoiceRepoImpl inputInvoiceRepoImpl;
    @Autowired
    private InputInvoiceDetailRepoImpl inputInvoiceDetailRepo;
    @Override
    public int addNewInputInvoice(InputInvoiceDto dto) {
        Date currentDate = new Date();
        int inputInvoiceId = this.inputInvoiceRepoImpl.addNewInputInvoice(currentDate, dto.getSupplierIdDto().getSupplierId());
        return 0;
    }
}
