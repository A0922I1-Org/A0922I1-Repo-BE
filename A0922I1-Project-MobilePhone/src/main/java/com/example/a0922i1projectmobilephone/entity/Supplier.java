package com.example.a0922i1projectmobilephone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer supplierId;
    @Column(name = "supplier_name")
    private String supplierName;
    @Column(name = "supplier_phone")
    private String supplierPhone;
    @Column(name = "supplier_email")
    private String supplierEmail;
    @Column(name = "supplier_address")
    private String supplierAddress;
    @OneToMany(mappedBy = "supplier" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<InputInvoice> inputInvoice;
}
