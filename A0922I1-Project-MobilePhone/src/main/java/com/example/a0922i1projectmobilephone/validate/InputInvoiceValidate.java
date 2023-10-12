package com.example.a0922i1projectmobilephone.validate;

import com.example.a0922i1projectmobilephone.dto.input_invoice.ProductInputDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class InputInvoiceValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProductInputDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
