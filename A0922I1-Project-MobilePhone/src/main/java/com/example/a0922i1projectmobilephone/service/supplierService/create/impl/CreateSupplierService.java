package com.example.a0922i1projectmobilephone.service.supplierService.create.impl;

import com.example.a0922i1projectmobilephone.dto.input_invoice.supplier.SupplierDtoCreateUpdate;
import com.example.a0922i1projectmobilephone.repository.supplierRepository.create.impl.CreateSupplierRepository;
import com.example.a0922i1projectmobilephone.service.supplierService.create.ICreateSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSupplierService implements ICreateSupplierService {
    @Autowired
    CreateSupplierRepository createSupplierRepository;

    public void addNewSupplier(SupplierDtoCreateUpdate supplier){
        createSupplierRepository.addNewSupplier(supplier.getSupplierAddress(), supplier.getSupplierEmail(), supplier.getSupplierName(), supplier.getSupplierPhone());
    }

}
