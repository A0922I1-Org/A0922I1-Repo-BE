package com.example.a0922i1projectmobilephone.validate;

import com.example.a0922i1projectmobilephone.dto.supplier.SupplierDtoCreateUpdate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SupplierValidate {

    public Map<String,String> checkValidate(SupplierDtoCreateUpdate supplier){
        Map<String,String> errors = new HashMap<>();
        if (Objects.equals(supplier.getSupplierName(), "errorName")) {
            errors.put("1", "Tên nhà cung cấp đã tồn tại");
        }if (Objects.equals(supplier.getSupplierPhone(), "errorPhone")) {
            errors.put("2", "Số điện thoại đã tồn tại");
        }if (Objects.equals(supplier.getSupplierEmail(), "errorEmail")){
            errors.put("3","Email đã tồn tại");
        }

        return errors;
    }
}
