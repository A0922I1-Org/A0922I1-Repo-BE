package com.example.a0922i1projectmobilephone.service.supplierService.update;

import com.example.a0922i1projectmobilephone.controller.dto.SupplierDtoCreateUpdate;
import com.example.a0922i1projectmobilephone.entity.Supplier;

public interface IUpdateSupplierService {
    Supplier findById(int supplier_id);
    void updateSupplier(SupplierDtoCreateUpdate supplier);

}
