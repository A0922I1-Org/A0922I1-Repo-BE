package com.example.a0922i1projectmobilephone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VNPayResponse {
    private VNPayDTO vnPayDTO;
    private int paymentStatus;

    public VNPayDTO getVnPayDTO() {
        return vnPayDTO;
    }

    public void setVnPayDTO(VNPayDTO vnPayDTO) {
        this.vnPayDTO = vnPayDTO;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
