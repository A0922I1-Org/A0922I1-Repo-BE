package com.example.a0922i1projectmobilephone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OutputInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer outputInvoiceId;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name="output_invoice_day")
    private Date dayOutput;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;
    @OneToMany(mappedBy = "outputInvoice" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<OutputInvoiceDetail> outputInvoiceDetail;

}
