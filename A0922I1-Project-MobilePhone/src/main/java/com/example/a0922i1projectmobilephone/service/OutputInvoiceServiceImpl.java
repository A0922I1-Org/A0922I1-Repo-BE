package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.entity.ManagerPurchaseHistory;
import com.example.a0922i1projectmobilephone.repository.OutputInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OutputInvoiceServiceImpl implements Output_invoiceService {
    @Autowired
    private OutputInvoiceRepository outputInvoiceRepository;
    @Override
    public Page<ManagerPurchaseHistory> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.getAll(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByTotalPrice(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.sortByTotalPrice(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByCustomerName(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.sortByCustomerName(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByProductName(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.sortByProduct_name(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByDateOutputInvoice(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.sortByDateOutputInvoice(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByQuantity(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.sortByQuantity(pageable);
    }

}

