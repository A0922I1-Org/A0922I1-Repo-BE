package com.example.a0922i1projectmobilephone.service.output_invoice;

import com.example.a0922i1projectmobilephone.dto.output_invoice.*;
import com.example.a0922i1projectmobilephone.dto.report.Report;
import com.example.a0922i1projectmobilephone.entity.ManagerPurchaseHistory;
import com.example.a0922i1projectmobilephone.repository.customer_repo.IRepositoryCustomer;
import com.example.a0922i1projectmobilephone.repository.output_invoice.IRepositoryProduct;
import com.example.a0922i1projectmobilephone.repository.output_invoice.OutputInvoiceDetailRepository;
import com.example.a0922i1projectmobilephone.repository.output_invoice.OutputInvoiceRepository;
import com.example.a0922i1projectmobilephone.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OutputInvoiceServiceImp implements OutputInvoiceService {
    @Autowired
    private OutputInvoiceRepository outputInvoiceRepository;
    @Autowired
    private OutputInvoiceDetailRepository invoiceDetailRepository;
    @Autowired
    private IRepositoryCustomer customerRepository;
    @Autowired
    private IProductRepository productRepository;


    @Override
    @Transactional
    /**
     * NhanTP
     * Create Output Invoice
     */
    public void saveOutputInvoice(OutputInvoiceDTO request) {
        OutputInvoiceDTO outputInvoice = new OutputInvoiceDTO();
        CustomerDTO customer = request.getCustomerDTO();
        Integer customerId = customer.getCustomerId();
        if (customer.getCustomerId() == null) {
            customerRepository.saveCustomer(customer.getCustomerName(),customer.getCustomerPhone(), customer.getCustomerAddress(), customer.getCustomerEmail());
            customerId = customerRepository.getLastCustomerId();
        }

        CustomerResponseDTO customerResponseDTO = customerRepository.findCustomerById(customerId);
        outputInvoice.setPaymentMethod(request.getPaymentMethod());
        outputInvoice.setTotalPrice(0.0);
        LocalDateTime currentDate = LocalDateTime.now();
        outputInvoice.setDateOutputInvoice(currentDate);
        outputInvoiceRepository.saveOutputInvoice(outputInvoice.getPaymentMethod(), outputInvoice.getTotalPrice(), outputInvoice.getDateOutputInvoice(), customerResponseDTO.getCustomer_id());
        outputInvoice.setOutputInvoiceId(outputInvoiceRepository.getLastOutputInvoiceId());

        if (request.getOutputInvoiceDetails() != null) {
            for (OutputInvoiceDetailDTO outputInvoiceDetail : request.getOutputInvoiceDetails()) {
                Integer productId = outputInvoiceDetail.getProductDTO().getProductId();
                ProductResponseDTO productResponseDTO = productRepository.findProductDTOById(productId);
                Integer costPrice = productResponseDTO.getSelling_price_product();
                Integer quantityProduct = productResponseDTO.getQuantity_product();
                ProductDTO product = new ProductDTO();
                product.setProductId(productId);
                product.setSellingPrice(costPrice);
                outputInvoiceDetail.setProductDTO(product);

                outputInvoiceDetail.setQuantity(outputInvoiceDetail.getQuantity());
                outputInvoiceDetail.setSubTotal(outputInvoiceDetail.getProductDTO().getSellingPrice() * outputInvoiceDetail.getQuantity());
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
        outputInvoiceRepository.updateTotalPrice(outputInvoice.getOutputInvoiceId(), outputInvoice.getTotalPrice());
    }

    @Override
    public long countById(String fromDay, String toDay, Integer id) {
        return outputInvoiceRepository.CountByID(fromDay, toDay, id);
    }

    @Override
    public long countAll(String fromDay, String toDay) {
        return outputInvoiceRepository.CountAll(fromDay, toDay);
    }

    @Override
    public long calculateRevenueByProductId(String fromDate, String toDate, Integer productId) {
        List<Report> reports = null;
        reports = outputInvoiceRepository.findByDayAndProductId(fromDate, toDate, productId);
        long totalRevenue = 0;
        for (Report report : reports) {
            double revenue = report.getCost() - (report.getInput_invoice_cost()/report.getAmount());
            totalRevenue += revenue;
        }
        return totalRevenue;
    }

    @Override
    public long calculateRevenue(String fromDate, String toDate) {
        List<Report> reports = null;
        reports = outputInvoiceRepository.findByDay(fromDate, toDate);
        long totalRevenue = 0;
        for (Report report : reports) {
            double revenue = report.getCost() - (report.getInput_invoice_cost()/report.getAmount());
            totalRevenue += revenue;
        }
        return totalRevenue;
    }

    // thuận
    @Override
    public Page<ManagerPurchaseHistory> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.getAll(pageable);
    }
    @Override
    public Page<ManagerPurchaseHistory> sortByTotalPrice(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.sortByTotalPrice(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByCustomerName(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.sortByCustomerName(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByProductName(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.sortByProduct_name(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByDateOutputInvoice(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.sortByDateOutputInvoice(pageable);
    }

    @Override
    public Page<ManagerPurchaseHistory> sortByQuantity(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return outputInvoiceRepository.sortByQuantity(pageable);
    }

}