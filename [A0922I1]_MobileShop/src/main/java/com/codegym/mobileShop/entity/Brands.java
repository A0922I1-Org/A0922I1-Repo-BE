package com.codegym.mobileShop.entity;

import javax.persistence.*;
import java.util.Set;

public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int brand_id;
    private String brand_name;
    @OneToMany(mappedBy = "brands" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Products> products;

    public Brands(int brand_id, String brand_name, Set<Products> products) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.products = products;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
