package com.example.a0922i1projectmobilephone.controller;
import com.example.a0922i1projectmobilephone.dto.InputInvoiceDetailListDto;
import com.example.a0922i1projectmobilephone.dto.SupplierIdDto;
import com.example.a0922i1projectmobilephone.entity.InputInvoiceDetail;
import com.example.a0922i1projectmobilephone.entity.Supplier;
import com.example.a0922i1projectmobilephone.service.InputInvoiceDetailService;
import com.example.a0922i1projectmobilephone.service.InputInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/input-invoice")
@CrossOrigin(origins = "http://localhost:4200")
public class InputInvoiceController {
    @Autowired
    private InputInvoiceDetailService inputInvoiceDetailService;
    @Autowired
    private InputInvoiceService inputInvoiceService;

    @GetMapping("/list")
    public ResponseEntity<Page<InputInvoiceDetail>> getAllInputInvoiceDetail(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ){
        Page<InputInvoiceDetail> inputInvoiceDetails = this.inputInvoiceDetailService.getInputInvoiceDetail(pageNo-1, pageSize);
        return new ResponseEntity<>(inputInvoiceDetails, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Page<InputInvoiceDetail>> search(
            @RequestParam String supplierName,
            @RequestParam String productName,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ){
        Page<InputInvoiceDetail> inputInvoiceDetails = this.inputInvoiceDetailService.search(supplierName, productName,startDate,endDate,pageNo-1,pageSize);
        return new ResponseEntity<>(inputInvoiceDetails, HttpStatus.OK);
    }

    @PostMapping("/new-input-invoice")
    public ResponseEntity<SupplierIdDto> addNewInputInvoice(
            @RequestBody SupplierIdDto supplier
            ){
        System.out.println("Đã vào method");
        System.out.println(supplier.getSupplierId());

        this.inputInvoiceService.addNewInputInvoice(supplier);
        return new ResponseEntity<>(supplier ,HttpStatus.CREATED);
    }

    public ResponseEntity<> addNewInputDetail(
            @RequestBody
    )
}
