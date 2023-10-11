package com.example.a0922i1projectmobilephone.controller.supplierController;

import com.example.a0922i1projectmobilephone.controller.dto.SupplierDtoCreateUpdate;
import com.example.a0922i1projectmobilephone.entity.Supplier;
import com.example.a0922i1projectmobilephone.service.supplierService.create.ICreateSupplierService;
import com.example.a0922i1projectmobilephone.service.supplierService.update.IUpdateSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
@CrossOrigin("*")
public class SupplierController {
    @Autowired
    ICreateSupplierService createSupplierService;
    @Autowired
    IUpdateSupplierService updateSupplierService;
    @PostMapping("/create")
    public ResponseEntity<SupplierDtoCreateUpdate> addSupplier(
        @Validated @RequestBody SupplierDtoCreateUpdate supplier,
        BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(supplier, HttpStatus.BAD_REQUEST);

        }else {
            this.createSupplierService.addNewSupplier(supplier);

        }
        return new ResponseEntity<>(supplier, HttpStatus.CREATED);
    }
    @GetMapping ("/edit{supplier_id}")
    public ResponseEntity<Supplier> editSupplier(
            @PathVariable int supplier_id){
            Supplier supplier = updateSupplierService.findById(supplier_id);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<SupplierDtoCreateUpdate> updateSuppier(
            @Validated @RequestBody SupplierDtoCreateUpdate supplier,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(supplier, HttpStatus.BAD_REQUEST);

        }else {
            this.updateSupplierService.updateSupplier(supplier);

        }
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }
}
