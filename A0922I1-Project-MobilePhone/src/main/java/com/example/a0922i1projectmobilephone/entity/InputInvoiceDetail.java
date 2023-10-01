package com.example.a0922i1projectmobilephone.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InputInvoiceDetail {
    @Id
    @GeneratedValue
    private Integer inputInvoiceDetailId;
    @Column(name = "input_invoice_cost")
    private double inputInvoiceCost;
    @Column(name = "amount")
    private int amount;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "input_invoice_id", referencedColumnName = "inputInvoiceId")
    private InputInvoice inputInvoice;

}
