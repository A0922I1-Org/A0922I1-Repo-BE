package com.example.a0922i1projectmobilephone.dto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FormatDate.class)
public @interface ValidateFormat {
    String message() default
            "Ngày không được lớn hơn hiện tại";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

