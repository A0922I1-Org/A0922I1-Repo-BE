package com.example.a0922i1projectmobilephone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    @Column(name = "date_output_invoice")
    private LocalDateTime dateOutputInvoice;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;
    @OneToMany(mappedBy = "outputInvoice" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<OutputInvoiceDetail> outputInvoiceDetail;


}
