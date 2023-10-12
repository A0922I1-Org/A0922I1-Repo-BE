package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.entity.ManagerPurchaseHistory;
import com.example.a0922i1projectmobilephone.service.Output_invoiceService;
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
    private Output_invoiceService output_invoiceService;

    @GetMapping("/managerPurchaseHistory")
    public ResponseEntity<Page<ManagerPurchaseHistory>> getAll(
        @RequestParam(defaultValue = "1") int pageNo,
        @RequestParam(defaultValue = "8") int pageSize ){
            Page<ManagerPurchaseHistory> page= output_invoiceService.getAll(pageNo,pageSize);
        return new ResponseEntity<>(page, HttpStatus.OK);
        }
    @GetMapping("/managerPurchaseHistory/sortByCustomerName")
    public ResponseEntity<Page<ManagerPurchaseHistory>> sortByCustomerName(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize ){
        Page<ManagerPurchaseHistory> page= output_invoiceService.sortByCustomerName(pageNo,pageSize);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @GetMapping("/managerPurchaseHistory/sortByProductName")
    public ResponseEntity<Page<ManagerPurchaseHistory>> sortByProduct_name(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize ){
        Page<ManagerPurchaseHistory> page= output_invoiceService.sortByProductName(pageNo,pageSize);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @GetMapping("/managerPurchaseHistory/sortByQuantity")
    public ResponseEntity<Page<ManagerPurchaseHistory>> sortByQuantity(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize ){
        Page<ManagerPurchaseHistory> page= output_invoiceService.sortByQuantity(pageNo,pageSize);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @GetMapping("/managerPurchaseHistory/sortByDateOutputInvoice")
    public ResponseEntity<Page<ManagerPurchaseHistory>> sortByDateOutputInvoice(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize ){
        Page<ManagerPurchaseHistory> page= output_invoiceService.sortByDateOutputInvoice(pageNo,pageSize);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @GetMapping("/managerPurchaseHistory/sortByTotalPrice")
    public ResponseEntity<Page<ManagerPurchaseHistory>> sortByTotalPrice(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize ){
        Page<ManagerPurchaseHistory> page= output_invoiceService.sortByTotalPrice(pageNo,pageSize);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
}


