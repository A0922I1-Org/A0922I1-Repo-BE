package com.codegym.mobileShop.entity;

import javax.persistence.*;

public class Output_Invoice_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int output_invoice_detail_id;
    private int quantity;
    private int sub_total;
    private int output_invoice_id;
    private int product_id;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Products products;
    @ManyToOne
    @JoinColumn(name = "output_invoice_id", referencedColumnName = "output_invoice_id")
    private Output_invoice output_invoices;

    public Output_Invoice_detail() {
    }

    public Output_Invoice_detail(int output_invoice_detail_id, int quantity, int sub_total, int output_invoice_id, int product_id, Products products, Output_invoice output_invoices) {
        this.output_invoice_detail_id = output_invoice_detail_id;
        this.quantity = quantity;
        this.sub_total = sub_total;
        this.output_invoice_id = output_invoice_id;
        this.product_id = product_id;
        this.products = products;
        this.output_invoices = output_invoices;
    }

    public int getOutput_invoice_detail_id() {
        return output_invoice_detail_id;
    }

    public void setOutput_invoice_detail_id(int output_invoice_detail_id) {
        this.output_invoice_detail_id = output_invoice_detail_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSub_total() {
        return sub_total;
    }

    public void setSub_total(int sub_total) {
        this.sub_total = sub_total;
    }

    public int getOutput_invoice_id() {
        return output_invoice_id;
    }

    public void setOutput_invoice_id(int output_invoice_id) {
        this.output_invoice_id = output_invoice_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Output_invoice getOutput_invoices() {
        return output_invoices;
    }

    public void setOutput_invoices(Output_invoice output_invoices) {
        this.output_invoices = output_invoices;
    }
}
