package com.codegym.mobileShop.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Input_invoice_detail {
    @Id
    @GeneratedValue
    private int input_invoice_detail_id;
    private double input_invoice_cost;
    private int amount;
    private int product_id;
    private int input_invoice_id;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Products products;
    @ManyToOne
    @JoinColumn(name = "input_invoice_id", referencedColumnName = "input_invoice_id")
    private Input_Invoice input_invoice;

    public Input_invoice_detail() {
    }

    public Input_invoice_detail(int input_invoice_detail_id, double input_invoice_cost, int amount, int product_id, int input_invoice_id, Products products, Input_Invoice input_invoice) {
        this.input_invoice_detail_id = input_invoice_detail_id;
        this.input_invoice_cost = input_invoice_cost;
        this.amount = amount;
        this.product_id = product_id;
        this.input_invoice_id = input_invoice_id;
        this.products = products;
        this.input_invoice = input_invoice;
    }

    public int getInput_invoice_detail_id() {
        return input_invoice_detail_id;
    }

    public void setInput_invoice_detail_id(int input_invoice_detail_id) {
        this.input_invoice_detail_id = input_invoice_detail_id;
    }

    public double getInput_invoice_cost() {
        return input_invoice_cost;
    }

    public void setInput_invoice_cost(double input_invoice_cost) {
        this.input_invoice_cost = input_invoice_cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getInput_invoice_id() {
        return input_invoice_id;
    }

    public void setInput_invoice_id(int input_invoice_id) {
        this.input_invoice_id = input_invoice_id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Input_Invoice getInput_invoice() {
        return input_invoice;
    }

    public void setInput_invoice(Input_Invoice input_invoice) {
        this.input_invoice = input_invoice;
    }
}
