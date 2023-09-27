package com.codegym.mobileShop.entity;

import javax.persistence.*;
import java.util.Set;

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_id;
    private String customer_name;
    private String number_phone;
    private String address;
    private int age;
    private String email;
    @OneToMany(mappedBy = "customer" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Output_invoice> output_invoices;

    public Customer() {
    }

    public Customer(int customer_id, String customer_name, String number_phone, String address, int age, String email, Set<Output_invoice> output_invoices) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.number_phone = number_phone;
        this.address = address;
        this.age = age;
        this.email = email;
        this.output_invoices = output_invoices;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Output_invoice> getOutput_invoices() {
        return output_invoices;
    }

    public void setOutput_invoices(Set<Output_invoice> output_invoices) {
        this.output_invoices = output_invoices;
    }
}
