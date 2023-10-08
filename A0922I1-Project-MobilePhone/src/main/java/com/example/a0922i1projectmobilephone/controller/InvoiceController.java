package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.entity.OutputInvoice;
import com.example.a0922i1projectmobilephone.service.OutputInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InvoiceController {
    @Autowired
    private OutputInvoiceService outputInvoiceService;

    @PostMapping("/payment")
    public ResponseEntity<?> payment(@RequestBody OutputInvoice request) {
        outputInvoiceService.payment(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping("/product")
//    public Optional<ProductDTO> findById(){
//        return outputInvoiceService.findByIdProduct1(1);
//    }
//
//    @GetMapping("/customer")
//    public Optional<CustomerDTO> findById1(){
//        return outputInvoiceService.findByIdCustomer2(1);
//    }
}
