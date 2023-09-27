package com.codegym.mobileShop.entity;

import javax.persistence.*;
import java.util.Set;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int category_id;
    private String category_name;
    @OneToMany(mappedBy = "category" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Products> products;

    public Category() {
    }

    public Category(int category_id, String category_name, Set<Products> products) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.products = products;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
