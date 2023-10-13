package com.example.a0922i1projectmobilephone.service.supplierService.update;

import com.example.a0922i1projectmobilephone.dto.input_invoice.supplier.SupplierDtoCreateUpdate;
import com.example.a0922i1projectmobilephone.entity.Supplier;

public interface IUpdateSupplierService {
    Supplier findById(int supplier_id);
    void updateSupplier(SupplierDtoCreateUpdate supplier);

}
