package com.example.a0922i1projectmobilephone.service;

import com.example.a0922i1projectmobilephone.dto.InputInvoiceDetailListDto;
import com.example.a0922i1projectmobilephone.repository.InputInvoiceDetailRepoImpl;
import com.example.a0922i1projectmobilephone.repository.InputInvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class InputInvoiceDetailServiceImpl implements InputInvoiceDetailService {

    @Autowired
    private InputInvoiceDetailRepository inputInvoiceDetailRepository;
    @Autowired
    private InputInvoiceDetailRepoImpl inputInvoiceDetailRepo;

    @Override
    public Page<InputInvoiceDetailListDto> getInputInvoiceDetail(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return inputInvoiceDetailRepository.getInputInvoiceDetail(pageable);
    }


    @Override
    public Page<InputInvoiceDetailListDto> search(String supplierName, String productName, String startDate, String endDate, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Date startDateConverted = null;
        Date endDateConverted = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        if (!startDate.isEmpty()) {
            try {

                startDateConverted = dateFormat.parse(startDate);
                System.out.println(startDateConverted);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!endDate.isEmpty()) {
            try {

                endDateConverted = dateFormat.parse(endDate);

                System.out.println(endDateConverted);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return this.inputInvoiceDetailRepo.search(supplierName, productName, startDateConverted, endDateConverted, pageable);

    }
}
