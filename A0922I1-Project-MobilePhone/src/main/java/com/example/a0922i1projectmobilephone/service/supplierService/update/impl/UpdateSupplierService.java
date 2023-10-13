package com.example.a0922i1projectmobilephone.service.supplierService.update.impl;

import com.example.a0922i1projectmobilephone.dto.input_invoice.supplier.SupplierDtoCreateUpdate;
import com.example.a0922i1projectmobilephone.entity.Supplier;
import com.example.a0922i1projectmobilephone.repository.supplierRepository.update.IUpdateSupplierRepository;
import com.example.a0922i1projectmobilephone.repository.supplierRepository.update.impl.UpdateSupplierRepository;
import com.example.a0922i1projectmobilephone.service.supplierService.update.IUpdateSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateSupplierService implements IUpdateSupplierService {
    @Autowired
    IUpdateSupplierRepository iUpdateSupplierRepository;
    @Autowired
    UpdateSupplierRepository updateSupplierRepository;




    @Override
    public Supplier findById(int supplier_id) {

        return iUpdateSupplierRepository.findById(supplier_id);
    }

    @Override
    public void updateSupplier(SupplierDtoCreateUpdate supplier) {
        updateSupplierRepository.updateSupplier(supplier.getSupplierAddress(), supplier.getSupplierEmail(), supplier.getSupplierName(),supplier.getSupplierPhone(),supplier.getSupplierId());
    }
}
