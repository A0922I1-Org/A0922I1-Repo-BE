package com.codegym.mobileShop.entity;

import javax.persistence.*;
import java.util.Set;

public class Output_invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int output_invoice_id;
    private String payment_method;
    private double total_price;
    private int customer_id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "output_invoice" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Output_Invoice_detail> output_invoice_details;

    public Output_invoice(int output_invoice_id, String payment_method, double total_price, int customer_id, Customer customer, Set<Output_Invoice_detail> output_invoice_details) {
        this.output_invoice_id = output_invoice_id;
        this.payment_method = payment_method;
        this.total_price = total_price;
        this.customer_id = customer_id;
        this.customer = customer;
        this.output_invoice_details = output_invoice_details;
    }

    public Output_invoice() {
    }

    public int getOutput_invoice_id() {
        return output_invoice_id;
    }

    public void setOutput_invoice_id(int output_invoice_id) {
        this.output_invoice_id = output_invoice_id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Output_Invoice_detail> getOutput_invoice_details() {
        return output_invoice_details;
    }

    public void setOutput_invoice_details(Set<Output_Invoice_detail> output_invoice_details) {
        this.output_invoice_details = output_invoice_details;
    }
}
