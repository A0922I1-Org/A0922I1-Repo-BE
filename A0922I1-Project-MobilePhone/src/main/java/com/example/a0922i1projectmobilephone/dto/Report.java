package com.example.a0922i1projectmobilephone.dto;
import java.util.Date;
public interface Report {

        Integer getProduct_id();

        String getProduct_name();
        Integer getCost();

        Date getOutput_invoice_day();
        int getAmount();

        Double getInput_invoice_cost();

}
