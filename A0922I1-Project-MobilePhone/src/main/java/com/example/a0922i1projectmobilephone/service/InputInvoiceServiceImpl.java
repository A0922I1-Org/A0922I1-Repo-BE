package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.repository.InputInvoiceRepoImpl;
import com.example.a0922i1projectmobilephone.repository.InputInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class InputInvoiceServiceImpl implements InputInvoiceService {
    @Autowired
    private InputInvoiceRepoImpl inputInvoiceRepoImpl;
    @Override
    public void addNewInputInvoice( Integer supplierId) {
        Date currentDate = new Date();
        this.inputInvoiceRepoImpl.addNewInputInvoice(currentDate, supplierId);
    }
}
