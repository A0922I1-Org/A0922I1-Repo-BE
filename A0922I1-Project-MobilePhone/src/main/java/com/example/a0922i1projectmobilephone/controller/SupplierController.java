package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.dto.supplier.SupplierDtoCreateUpdate;
import com.example.a0922i1projectmobilephone.entity.Supplier;
<<<<<<< HEAD:A0922I1-Project-MobilePhone/src/main/java/com/example/a0922i1projectmobilephone/controller/supplierController/SupplierController.java
import com.example.a0922i1projectmobilephone.service.supplierService.list.IListSupplierService;
import com.example.a0922i1projectmobilephone.validate.SupplierValidate;
=======
import com.example.a0922i1projectmobilephone.service.supplierService.ISupplierService;
>>>>>>> main:A0922I1-Project-MobilePhone/src/main/java/com/example/a0922i1projectmobilephone/controller/SupplierController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.example.a0922i1projectmobilephone.service.supplierService.create.ICreateSupplierService;
import com.example.a0922i1projectmobilephone.service.supplierService.update.IUpdateSupplierService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    IListSupplierService supplierService;

    @Autowired
    ICreateSupplierService createSupplierService;
    @Autowired
    IUpdateSupplierService updateSupplierService;
    @Autowired
    SupplierValidate supplierValidate;
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

    @PostMapping("/create")
    public ResponseEntity<?> addSupplier(
            @Validated @RequestBody SupplierDtoCreateUpdate supplier,
            BindingResult bindingResult
    ){
        Map<String, String> errordata = supplierValidate.checkValidate(createSupplierService.checkdata(supplier));
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(supplier, HttpStatus.BAD_REQUEST);
        }if (!errordata.isEmpty()){
            return new ResponseEntity<>(errordata, HttpStatus.BAD_REQUEST);
        }else {
            createSupplierService.addNewSupplier(supplier);
            return new ResponseEntity<>(supplier, HttpStatus.CREATED);
        }

    }
    @GetMapping ("/edit/{supplier_id}")
    public ResponseEntity<Supplier> editSupplier(
            @PathVariable int supplier_id){
        Supplier supplier = updateSupplierService.findById(supplier_id);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateSuppier(
            @Validated @RequestBody SupplierDtoCreateUpdate supplier,
            BindingResult bindingResult
    ){
        Map<String, String> errordata = supplierValidate.checkValidate(updateSupplierService.checkData(supplier));
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(supplier, HttpStatus.BAD_REQUEST);
        }if (!errordata.isEmpty()){
            return new ResponseEntity<>(errordata, HttpStatus.BAD_REQUEST);
        }else {
            updateSupplierService.updateSupplier(supplier);
            return new ResponseEntity<>(supplier, HttpStatus.CREATED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable Integer id){
        return new ResponseEntity<>(this.supplierService.findById(id).get(), HttpStatus.OK);
    }

}
