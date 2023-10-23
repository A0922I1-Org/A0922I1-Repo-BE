package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.dto.output_invoice.OutputInvoiceDTO;
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
    private OutputInvoiceServiceImp outputInvoiceService;
    @PostMapping("/payment")
    public ResponseEntity<?> payment(@RequestBody OutputInvoiceDTO request) {
        outputInvoiceService.saveOutputInvoice(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/managerPurchaseHistory")
    public ResponseEntity<Page<ManagerPurchaseHistory>> getAll(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize,
            @RequestParam(required = false) String sort) {
        Page<ManagerPurchaseHistory> page;
        switch (sort) {
            case "customerName":
                page = outputInvoiceService.sortByCustomerName(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
            case "productName":
                page = outputInvoiceService.sortByProductName(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
            case "totalPrice":
                page = outputInvoiceService.sortByTotalPrice(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
            case "quantity":
                page = outputInvoiceService.sortByQuantity(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
            case "time":
                page = outputInvoiceService.sortByDateOutputInvoice(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
            default:
                page = outputInvoiceService.getAll(pageNo, pageSize);
                return new ResponseEntity<>(page, HttpStatus.OK);
        }
    }
}


