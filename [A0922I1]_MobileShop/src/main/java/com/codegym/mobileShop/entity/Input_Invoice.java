package com.codegym.mobileShop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

public class Input_Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int input_invoice_id;
    private Date input_invoice_date;
    private int supplier_id;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    private Supplier supplier;
    @OneToMany(mappedBy = "input_invoice" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Input_invoice_detail> input_invoice_details;

    public Input_Invoice() {
    }

    public Input_Invoice(int input_invoice_id, Date input_invoice_date, int supplier_id, Supplier supplier, Set<Input_invoice_detail> input_invoice_details) {
        this.input_invoice_id = input_invoice_id;
        this.input_invoice_date = input_invoice_date;
        this.supplier_id = supplier_id;
        this.supplier = supplier;
        this.input_invoice_details = input_invoice_details;
    }

    public int getInput_invoice_id() {
        return input_invoice_id;
    }

    public void setInput_invoice_id(int input_invoice_id) {
        this.input_invoice_id = input_invoice_id;
    }

    public Date getInput_invoice_date() {
        return input_invoice_date;
    }

    public void setInput_invoice_date(Date input_invoice_date) {
        this.input_invoice_date = input_invoice_date;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<Input_invoice_detail> getInput_invoice_details() {
        return input_invoice_details;
    }

    public void setInput_invoice_details(Set<Input_invoice_detail> input_invoice_details) {
        this.input_invoice_details = input_invoice_details;
    }
}
