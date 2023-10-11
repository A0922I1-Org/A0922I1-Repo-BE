package com.example.a0922i1projectmobilephone.controller.supplierController;

<<<<<<< HEAD
import com.example.a0922i1projectmobilephone.entity.Supplier;
import com.example.a0922i1projectmobilephone.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;
    @GetMapping("/paged")
    public ResponseEntity<Page<Supplier>> getAllSupplier(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize) {
        Page<Supplier> page = supplierService.findAll(pageNo, pageSize);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/sort/name")
    public ResponseEntity<Page<Supplier>> sortByNameSupplier(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize,
            @RequestParam int flag) {
        Page<Supplier> page = supplierService.sortBySupplierName(flag,pageNo, pageSize);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }



    @GetMapping("/sort/id")
    public ResponseEntity<Page<Supplier>> sortByIdSupplier(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize,
            @RequestParam int flag) {
        Page<Supplier> page = supplierService.sortBySupplierId(flag,pageNo, pageSize);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Integer id) {
        if (!supplierService.existsById(id)) {
            return new ResponseEntity<>("Nhà cung cấp không tồn tại", HttpStatus.NOT_FOUND);
        }

        supplierService.deleteById(id);
        return new ResponseEntity<>("Đã xóa nhà cung cấp thành công", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Supplier>> searchSupplier(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String phone,
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "8") int pageSize) {
        Page<Supplier> page = supplierService.searchSuppliers(name, address, phone, pageNo, pageSize);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }



}
=======
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
>>>>>>> NghiaBH-c-u-supplier
