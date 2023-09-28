package com.example.a0922i1projectmobilephone.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "screen_size")
    private String screenSize;
    @Column(name = "front_camera")
    private String frontCamera;
    @Column(name = "back_camera")
    private String backCamera;
    @Column(name = "product_cpu")
    private String productCpu;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "product_storage")
    private String productStorage;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "product" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<InputInvoiceDetail> inputInvoiceDetails;
    @OneToMany(mappedBy = "product" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<OutputInvoiceDetail> outputInvoiceDetails;
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "brandId")
    private Brand brand;
}
