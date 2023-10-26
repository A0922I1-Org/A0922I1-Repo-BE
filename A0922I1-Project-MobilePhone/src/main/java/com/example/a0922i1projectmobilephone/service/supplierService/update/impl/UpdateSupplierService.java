package com.example.a0922i1projectmobilephone.service.supplierService.update.impl;

import com.example.a0922i1projectmobilephone.dto.supplier.SupplierDtoCreateUpdate;
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
    public Supplier findById(int id) {

        return iUpdateSupplierRepository.findById(id);
    }

    @Override
    public SupplierDtoCreateUpdate updateSupplier(SupplierDtoCreateUpdate supplier) {
        updateSupplierRepository.updateSupplier(supplier.getSupplierAddress(), supplier.getSupplierEmail(), supplier.getSupplierName(), supplier.getSupplierPhone(), supplier.getSupplierId());
        return supplier;
    }
    @Override
    public SupplierDtoCreateUpdate checkData(SupplierDtoCreateUpdate supplier) {
        for (Supplier supplier1 : iUpdateSupplierRepository.findAllSupplier()) {
            if (supplier1.getSupplierId().equals(supplier.getSupplierId())) {continue;}
            if (supplier.getSupplierName().equals(supplier1.getSupplierName())) {
                    supplier.setSupplierName("errorName");
            }if (supplier1.getSupplierPhone().equals(supplier.getSupplierPhone())) {
                    supplier.setSupplierPhone("errorPhone");
            }if (supplier1.getSupplierEmail().equals(supplier.getSupplierEmail())) {
                    supplier.setSupplierEmail("errorEmail");
            }
    }
        return supplier;
    }
}
