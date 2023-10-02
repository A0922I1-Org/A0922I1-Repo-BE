package com.example.a0922i1projectmobilephone.dto;
import com.example.a0922i1projectmobilephone.entity.InputInvoice;
import com.example.a0922i1projectmobilephone.entity.Product;

public class InputInvoiceDetailAddNewDto {
    private double inputInvoiceCost;
    private int amount;
    private Product product;

    public InputInvoiceDetailAddNewDto() {
    }

    public InputInvoiceDetailAddNewDto(double inputInvoiceCost, int amount, Product product, InputInvoice inputInvoice) {
        this.inputInvoiceCost = inputInvoiceCost;
        this.amount = amount;
        this.product = product;
    }

    public double getInputInvoiceCost() {
        return inputInvoiceCost;
    }

    public void setInputInvoiceCost(double inputInvoiceCost) {
        this.inputInvoiceCost = inputInvoiceCost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
