package com.example.a0922i1projectmobilephone.service.output_invoice;

import com.example.a0922i1projectmobilephone.dto.report.Report;
import com.example.a0922i1projectmobilephone.entity.ManagerPurchaseHistory;
import com.example.a0922i1projectmobilephone.repository.OutputInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutputInvoiceServiceImp implements OutputInvoiceService {
    @Autowired
    private OutputInvoiceRepository reportRepository;


    @Override
    public long countById(String fromDay, String toDay, Integer id) {
        return reportRepository.CountByID(fromDay, toDay, id);
    }

    @Override
    public long countAll(String fromDay, String toDay) {
        return reportRepository.CountAll(fromDay, toDay);
    }

    @Override
    public long calculateRevenueByProductId(String fromDate, String toDate, Integer productId) {
        List<Report> reports = null;
        reports = reportRepository.findByDayAndProductId(fromDate, toDate, productId);
        long totalRevenue = 0;
        for (Report report : reports) {
            double revenue = report.getCost() - (report.getInput_invoice_cost()/report.getAmount());
            totalRevenue += revenue;
        }
        return totalRevenue;
    }

    @Override
    public long calculateRevenue(String fromDate, String toDate) {
        List<Report> reports = null;
        reports = reportRepository.findByDay(fromDate, toDate);
        long totalRevenue = 0;
        for (Report report : reports) {
            double revenue = report.getCost() - (report.getInput_invoice_cost()/report.getAmount());
            totalRevenue += revenue;
        }
        return totalRevenue;
    }

    // thuận
    @Override
    public Page<ManagerPurchaseHistory> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return reportRepository.getAll(pageable);
    }
    @Override
    public Page<ManagerPurchaseHistory> sortByTotalPrice(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return reportRepository.sortByTotalPrice(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByCustomerName(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return reportRepository.sortByCustomerName(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByProductName(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return reportRepository.sortByProduct_name(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByDateOutputInvoice(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return reportRepository.sortByDateOutputInvoice(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByQuantity(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return reportRepository.sortByQuantity(pageable);
    }

}