package com.example.a0922i1projectmobilephone.service.supplierService.create.impl;

import com.example.a0922i1projectmobilephone.dto.supplier.SupplierDtoCreateUpdate;
import com.example.a0922i1projectmobilephone.entity.Supplier;
import com.example.a0922i1projectmobilephone.repository.supplierRepository.create.ICreateSupplierRepository;
import com.example.a0922i1projectmobilephone.repository.supplierRepository.create.impl.CreateSupplierRepository;
import com.example.a0922i1projectmobilephone.service.supplierService.create.ICreateSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSupplierService implements ICreateSupplierService {
    @Autowired
    CreateSupplierRepository createSupplierRepository;
    @Autowired
    ICreateSupplierRepository icreateSupplierRepository;

    @Override
    public SupplierDtoCreateUpdate addNewSupplier(SupplierDtoCreateUpdate supplier) {
         createSupplierRepository.addNewSupplier(supplier.getSupplierAddress(), supplier.getSupplierEmail(), supplier.getSupplierName(), supplier.getSupplierPhone());
        return supplier;
    }

    public SupplierDtoCreateUpdate checkdata(SupplierDtoCreateUpdate supplier) {

        for (Supplier supplier1 : icreateSupplierRepository.findAllSupplier()) {
            if (supplier.getSupplierName().equals(supplier1.getSupplierName())) {
                supplier.setSupplierName("errorName");
            }
            if (supplier1.getSupplierPhone().equals(supplier.getSupplierPhone())) {
                supplier.setSupplierPhone("errorPhone");
            }
            if (supplier1.getSupplierEmail().equals(supplier.getSupplierEmail())) {
                supplier.setSupplierEmail("errorEmail");
                return supplier;

            }

        }

        return supplier;
    }
}