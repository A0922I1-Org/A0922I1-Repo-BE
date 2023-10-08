package com.controller;

import com.dto.InvoiceDTO;
import com.entity.OutputInvoice;
import com.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
    @CrossOrigin(origins = "*", maxAge = 3600)
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @PostMapping("/payment")
    public ResponseEntity<?> payment(@RequestBody InvoiceDTO request) {
        invoiceService.payment(request);
//        return ResponseEntity.ok(new MessageResponse("Payment Successfully!"));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
