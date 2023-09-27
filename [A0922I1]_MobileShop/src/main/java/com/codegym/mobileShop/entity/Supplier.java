package com.codegym.mobileShop.entity;

import javax.persistence.*;
import java.util.Set;

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplier_id;
    private String supplier_name;
    private String number_phone;
    private String email;
    private String address;
    @OneToMany(mappedBy = "supplier" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Input_Invoice> input_Invoices;

    public Supplier() {
    }

    public Supplier(int supplier_id, String supplier_name, String number_phone, String email, String address, Set<Input_Invoice> input_Invoices) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.number_phone = number_phone;
        this.email = email;
        this.address = address;
        this.input_Invoices = input_Invoices;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Input_Invoice> getInput_Invoices() {
        return input_Invoices;
    }

    public void setInput_Invoices(Set<Input_Invoice> input_Invoices) {
        this.input_Invoices = input_Invoices;
    }
}
