package com.example.a0922i1projectmobilephone.service;
import com.example.a0922i1projectmobilephone.entity.OutputInvoice;

import java.util.Optional;


public interface OutputInvoiceService {
    void payment(OutputInvoice request);
}