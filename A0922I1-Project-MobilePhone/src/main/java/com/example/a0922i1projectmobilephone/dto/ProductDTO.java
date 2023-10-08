package com.example.a0922i1projectmobilephone.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface ProductDTO {
    Integer getCost_product();
    Integer getQuantity_product();
}
//@NoArgsConstructor
//@Getter
//@Setter
//public class ProductDTO {
//    private Integer product_id;
//    private Integer cost_product;
//
//    @JsonCreator
//    public ProductDTO(
//            @JsonProperty("product_id") Integer product_id,
//            @JsonProperty("cost_product") Integer cost_product
//    ) {
//        this.product_id = product_id;
//        this.cost_product = cost_product;
//    }
//}