package com.example.a0922i1projectmobilephone.dto.output_invoice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer productId;
    private Integer costPrice;
    private Integer quantity;
    private List<OutputInvoiceDetailDTO> outputInvoiceDetails;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public List<OutputInvoiceDetailDTO> getOutputInvoiceDetails() {
        return outputInvoiceDetails;
    }

    public void setOutputInvoiceDetails(List<OutputInvoiceDetailDTO> outputInvoiceDetails) {
        this.outputInvoiceDetails = outputInvoiceDetails;
    }
}
