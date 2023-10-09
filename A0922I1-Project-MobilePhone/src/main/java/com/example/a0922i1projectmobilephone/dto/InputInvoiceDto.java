package com.example.a0922i1projectmobilephone.dto;

public class InputInvoiceDto {
   private ProductInputDto[] productInputDto;
   private SupplierIdDto supplierIdDto;

    public InputInvoiceDto(ProductInputDto[] productInputDto, SupplierIdDto supplierIdDto) {
        this.productInputDto = productInputDto;
        this.supplierIdDto = supplierIdDto;
    }

    public InputInvoiceDto() {
    }

    public ProductInputDto[] getProductInputDto() {
        return productInputDto;
    }

    public void setProductInputDto(ProductInputDto[] productInputDto) {
        this.productInputDto = productInputDto;
    }

    public SupplierIdDto getSupplierIdDto() {
        return supplierIdDto;
    }

    public void setSupplierIdDto(SupplierIdDto supplierIdDto) {
        this.supplierIdDto = supplierIdDto;
    }
}
