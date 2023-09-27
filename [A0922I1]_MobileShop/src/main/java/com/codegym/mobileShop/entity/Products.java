package com.codegym.mobileShop.entity;

import javax.persistence.*;
import java.util.Set;

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_id;
    private String product_name;
    private int cost;
    private String screen_size;
    private String font_camera;
    private String back_camera;
    private String product_cpu;
    private String image_url;
    private String product_storage;
    private String decryption;
    private int category_id;
    private int brand_id;
    @OneToMany(mappedBy = "product" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Input_invoice_detail> input_invoice_details;
    @OneToMany(mappedBy = "product" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Output_Invoice_detail> output_invoice_details;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brands brands;

    public Products() {
    }

    public Products(int product_id, String product_name, int cost, String screen_size, String font_camera, String back_camera, String product_cpu, String image_url, String product_storage, String decryption, int category_id, int brand_id, Set<Input_invoice_detail> input_invoice_details, Set<Output_Invoice_detail> output_invoice_details, Category category, Brands brands) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.cost = cost;
        this.screen_size = screen_size;
        this.font_camera = font_camera;
        this.back_camera = back_camera;
        this.product_cpu = product_cpu;
        this.image_url = image_url;
        this.product_storage = product_storage;
        this.decryption = decryption;
        this.category_id = category_id;
        this.brand_id = brand_id;
        this.input_invoice_details = input_invoice_details;
        this.output_invoice_details = output_invoice_details;
        this.category = category;
        this.brands = brands;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(String screen_size) {
        this.screen_size = screen_size;
    }

    public String getFont_camera() {
        return font_camera;
    }

    public void setFont_camera(String font_camera) {
        this.font_camera = font_camera;
    }

    public String getBack_camera() {
        return back_camera;
    }

    public void setBack_camera(String back_camera) {
        this.back_camera = back_camera;
    }

    public String getProduct_cpu() {
        return product_cpu;
    }

    public void setProduct_cpu(String product_cpu) {
        this.product_cpu = product_cpu;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getProduct_storage() {
        return product_storage;
    }

    public void setProduct_storage(String product_storage) {
        this.product_storage = product_storage;
    }

    public String getDecryption() {
        return decryption;
    }

    public void setDecryption(String decryption) {
        this.decryption = decryption;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public Set<Input_invoice_detail> getInput_invoice_details() {
        return input_invoice_details;
    }

    public void setInput_invoice_details(Set<Input_invoice_detail> input_invoice_details) {
        this.input_invoice_details = input_invoice_details;
    }

    public Set<Output_Invoice_detail> getOutput_invoice_details() {
        return output_invoice_details;
    }

    public void setOutput_invoice_details(Set<Output_Invoice_detail> output_invoice_details) {
        this.output_invoice_details = output_invoice_details;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }
}
