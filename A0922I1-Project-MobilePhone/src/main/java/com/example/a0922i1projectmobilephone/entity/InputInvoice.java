package com.example.a0922i1projectmobilephone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InputInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer inputInvoiceId;
    @Column(name = "input_invoice_date")
    private Date inputInvoiceDate;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplierId")
    private Supplier supplier;
    @OneToMany(mappedBy = "inputInvoice",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<InputInvoiceDetail> inputInvoiceDetail;
}
