package com.example.a0922i1projectmobilephone.dto;

public class ProductInputDto {
    private Integer productId;
    private String productName;
    private Integer costPrice;
    private Integer quantity;

    public ProductInputDto() {
    }

    public ProductInputDto(Integer productId, String productName, Integer costPrice, Integer quantity) {
        this.productId = productId;
        this.productName = productName;
        this.costPrice = costPrice;
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
