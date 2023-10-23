package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.entity.ManagerPurchaseHistory;
import com.example.a0922i1projectmobilephone.service.output_invoice.OutputInvoiceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OutputInvoiceController {
    @Autowired
    private OutputInvoiceServiceImp output_invoiceService;

    @GetMapping("/managerPurchaseHistory")
    public ResponseEntity<Page<ManagerPurchaseHistory>> getAll(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize,
            @RequestParam(required = false) String sort) {
        Page<ManagerPurchaseHistory> page;
        switch (sort) {
            case "customerName":
                page = output_invoiceService.sortByCustomerName(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
            case "productName":
                page = output_invoiceService.sortByProductName(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
            case "totalPrice":
                page = output_invoiceService.sortByTotalPrice(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
            case "quantity":
                page = output_invoiceService.sortByQuantity(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
            case "time":
                page = output_invoiceService.sortByDateOutputInvoice(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
            default:
                page = output_invoiceService.getAll(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
        }
    }
}


