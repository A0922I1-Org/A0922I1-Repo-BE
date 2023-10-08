package com.example.a0922i1projectmobilephone.service.impl;


import com.example.a0922i1projectmobilephone.dto.CustomerDTO;
import com.example.a0922i1projectmobilephone.dto.OutputInvoiceDTO;
import com.example.a0922i1projectmobilephone.dto.OutputInvoiceDetailDTO;
import com.example.a0922i1projectmobilephone.dto.ProductDTO;
import com.example.a0922i1projectmobilephone.repository.CustomerRepository;
import com.example.a0922i1projectmobilephone.repository.InvoiceDetailRepository;
import com.example.a0922i1projectmobilephone.repository.InvoiceRepository;
import com.example.a0922i1projectmobilephone.repository.ProductRepository;
import com.example.a0922i1projectmobilephone.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void payment(OutputInvoiceDTO request) {
        OutputInvoiceDTO outputInvoice= new OutputInvoiceDTO();
        CustomerDTO customer = request.getCustomerDTO();

        if (customer.getCustomerId() == null) {
            customerRepository.save(customer);
        }

        Optional<CustomerDTO> existingCustomerOptional = customerRepository.findById(customer.getCustomerId());

        if (existingCustomerOptional.isPresent()) {
            CustomerDTO existingCustomer = existingCustomerOptional.get();
            outputInvoice.setCustomerDTO(existingCustomer);
        }

        outputInvoice.setPaymentMethod(request.getPaymentMethod());
        outputInvoice.setTotalPrice(0.0);

        invoiceRepository.saveOutputInvoice(outputInvoice.getPaymentMethod(), outputInvoice.getTotalPrice(), customer.getCustomerId());
        outputInvoice.setOutputInvoiceId(invoiceRepository.getLastOutputInvoiceId());
        if (request.getInvoiceDetail() != null) {
            for (OutputInvoiceDetailDTO outputInvoiceDetail : request.getInvoiceDetail()) {
                ProductDTO product = outputInvoiceDetail.getProductDTO();

                Optional<ProductDTO> productOptional = productRepository.findById(product.getProductId());

                if (productOptional.isPresent()) {
                    product = productOptional.get();
                    outputInvoiceDetail.setProductDTO(product);
                }

                outputInvoiceDetail.setProductDTO(product);
                outputInvoiceDetail.setQuantity(outputInvoiceDetail.getQuantity());
                outputInvoiceDetail.setSubTotal(product.getCostPrice() * outputInvoiceDetail.getQuantity());
                outputInvoiceDetail.setOutputInvoiceDTO(outputInvoice);

                invoiceDetailRepository.saveOutputInvoiceDetail(outputInvoiceDetail.getQuantity(), outputInvoiceDetail.getSubTotal(), outputInvoiceDetail.getOutputInvoiceDTO().getOutputInvoiceId(), product.getProductId());
                outputInvoice.setTotalPrice(outputInvoice.getTotalPrice() + outputInvoiceDetail.getSubTotal());
            }
        }
        invoiceRepository.updateTotalPrice(outputInvoice.getOutputInvoiceId(), outputInvoice.getTotalPrice());
    }


}