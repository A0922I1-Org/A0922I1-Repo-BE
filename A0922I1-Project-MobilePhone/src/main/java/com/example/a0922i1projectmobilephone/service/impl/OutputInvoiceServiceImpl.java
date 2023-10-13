package com.example.a0922i1projectmobilephone.service.impl;


import com.example.a0922i1projectmobilephone.dto.*;
import com.example.a0922i1projectmobilephone.entity.Customer;
import com.example.a0922i1projectmobilephone.entity.OutputInvoice;
import com.example.a0922i1projectmobilephone.entity.OutputInvoiceDetail;
import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.repository.*;
import com.example.a0922i1projectmobilephone.service.OutputInvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OutputInvoiceServiceImpl implements OutputInvoiceService {
    @Autowired
    private OutputInvoiceRepository invoiceRepository;
    @Autowired
    private OutputInvoiceDetailRepository invoiceDetailRepository;
    @Autowired
    private IRepositoryCustomer customerRepository;
    @Autowired
    private IRepositoryProduct   productRepository;


    @Override
    @Transactional
    public void payment(OutputInvoice request) {
        OutputInvoice outputInvoice = new OutputInvoice();
        Customer customer = request.getCustomer();
        Integer customerId = customer.getCustomerId();
        if (customer.getCustomerId() == null) {
            customerRepository.saveCustomer(customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerPhone(), customer.getCustomerEmail());
            customerId = customerRepository.getLastCustomerId();
        }

        CustomerDTO customerDTO = customerRepository.findCustomerById(customerId);
        outputInvoice.setPaymentMethod(request.getPaymentMethod());
        outputInvoice.setTotalPrice(0.0);

        invoiceRepository.saveOutputInvoice(outputInvoice.getPaymentMethod(), outputInvoice.getTotalPrice(), customerDTO.getCustomer_id());
        outputInvoice.setOutputInvoiceId(invoiceRepository.getLastOutputInvoiceId());

        if (request.getOutputInvoiceDetail() != null) {
            for (OutputInvoiceDetail outputInvoiceDetail : request.getOutputInvoiceDetail()) {
                Integer productId = outputInvoiceDetail.getProduct().getProductId();
                ProductDTO productDTO = productRepository.findProductById(productId);
                Integer costPrice = productDTO.getCost_product();
                Integer quantityProduct = productDTO.getQuantity_product();
                Product product = new Product();
                product.setProductId(productId);
                product.setCostPrice(costPrice);
                outputInvoiceDetail.setProduct(product);

                outputInvoiceDetail.setQuantity(outputInvoiceDetail.getQuantity());
                outputInvoiceDetail.setSubTotal(outputInvoiceDetail.getProduct().getCostPrice() * outputInvoiceDetail.getQuantity());
                if (quantityProduct < outputInvoiceDetail.getQuantity()) {
                    throw new IllegalArgumentException("Số lượng sản phẩm không đủ.");
                }
                product.setQuantity(quantityProduct - outputInvoiceDetail.getQuantity());

                outputInvoiceDetail.setOutputInvoice(outputInvoice);

                invoiceDetailRepository.saveOutputInvoiceDetail(outputInvoiceDetail.getQuantity(), outputInvoiceDetail.getSubTotal(), outputInvoiceDetail.getOutputInvoice().getOutputInvoiceId(), outputInvoiceDetail.getProduct().getProductId());
                productRepository.updateProduct(product.getProductId(), product.getQuantity());
                outputInvoice.setTotalPrice(outputInvoice.getTotalPrice() + outputInvoiceDetail.getSubTotal());
            }
        }
        invoiceRepository.updateTotalPrice(outputInvoice.getOutputInvoiceId(), outputInvoice.getTotalPrice());
    }
}