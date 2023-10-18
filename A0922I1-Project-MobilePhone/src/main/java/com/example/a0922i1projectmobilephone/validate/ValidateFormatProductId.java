package com.example.a0922i1projectmobilephone.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidateFormatProductId {
    String regex() default "\\d+";
    String message() default "Invalid ProductId";

}
