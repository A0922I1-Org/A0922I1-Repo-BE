package com.example.a0922i1projectmobilephone.service.impl;

import com.example.a0922i1projectmobilephone.dto.output_invoice.*;
import com.example.a0922i1projectmobilephone.repository.output_invoice.IRepositoryCustomer;
import com.example.a0922i1projectmobilephone.repository.output_invoice.IRepositoryProduct;
import com.example.a0922i1projectmobilephone.repository.output_invoice.OutputInvoiceDetailRepository;
import com.example.a0922i1projectmobilephone.repository.output_invoice.OutputInvoiceRepository;
import com.example.a0922i1projectmobilephone.service.OutputInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OutputInvoiceServiceImpl implements OutputInvoiceService {
    @Autowired
    private OutputInvoiceRepository invoiceRepository;
    @Autowired
    private OutputInvoiceDetailRepository invoiceDetailRepository;
    @Autowired
    private IRepositoryCustomer customerRepository;
    @Autowired
    private IRepositoryProduct productRepository;


    @Override
    @Transactional
    public void payment(OutputInvoiceDTO request) {
        OutputInvoiceDTO outputInvoice = new OutputInvoiceDTO();
        CustomerDTO customer = request.getCustomerDTO();
        Integer customerId = customer.getCustomerId();
        if (customer.getCustomerId() == null) {
            customerRepository.saveCustomer(customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerPhone(), customer.getCustomerEmail());
            customerId = customerRepository.getLastCustomerId();
        }

        CustomerResponseDTO customerResponseDTO = customerRepository.findCustomerById(customerId);
        outputInvoice.setPaymentMethod(request.getPaymentMethod());
        outputInvoice.setTotalPrice(0.0);
        LocalDateTime currentDate = LocalDateTime.now();
        outputInvoice.setDateOutputInvoice(currentDate);
        invoiceRepository.saveOutputInvoice(outputInvoice.getPaymentMethod(), outputInvoice.getTotalPrice(), outputInvoice.getDateOutputInvoice(), customerResponseDTO.getCustomer_id());
        outputInvoice.setOutputInvoiceId(invoiceRepository.getLastOutputInvoiceId());

        if (request.getOutputInvoiceDetails() != null) {
            for (OutputInvoiceDetailDTO outputInvoiceDetail : request.getOutputInvoiceDetails()) {
                Integer productId = outputInvoiceDetail.getProductDTO().getProductId();
                ProductResponseDTO productResponseDTO = productRepository.findProductById(productId);
                Integer costPrice = productResponseDTO.getCost_product();
                Integer quantityProduct = productResponseDTO.getQuantity_product();
                ProductDTO product = new ProductDTO();
                product.setProductId(productId);
                product.setCostPrice(costPrice);
                outputInvoiceDetail.setProductDTO(product);

                outputInvoiceDetail.setQuantity(outputInvoiceDetail.getQuantity());
                outputInvoiceDetail.setSubTotal(outputInvoiceDetail.getProductDTO().getCostPrice() * outputInvoiceDetail.getQuantity());
                if (quantityProduct < outputInvoiceDetail.getQuantity()) {
                    throw new IllegalArgumentException("Số lượng sản phẩm không đủ.");
                }
                product.setQuantity(quantityProduct - outputInvoiceDetail.getQuantity());

                outputInvoiceDetail.setOutputInvoiceDTO(outputInvoice);

                invoiceDetailRepository.saveOutputInvoiceDetail(outputInvoiceDetail.getQuantity(), outputInvoiceDetail.getSubTotal(), outputInvoiceDetail.getOutputInvoiceDTO().getOutputInvoiceId(), outputInvoiceDetail.getProductDTO().getProductId());
                productRepository.updateProduct(product.getProductId(), product.getQuantity());
                outputInvoice.setTotalPrice(outputInvoice.getTotalPrice() + outputInvoiceDetail.getSubTotal());
            }
        }
        invoiceRepository.updateTotalPrice(outputInvoice.getOutputInvoiceId(), outputInvoice.getTotalPrice());
    }
}