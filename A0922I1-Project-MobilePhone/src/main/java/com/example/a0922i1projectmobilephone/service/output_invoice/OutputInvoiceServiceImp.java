package com.example.a0922i1projectmobilephone.service.output_invoice;

import com.example.a0922i1projectmobilephone.dto.report.Report;
import com.example.a0922i1projectmobilephone.repository.OutputInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}