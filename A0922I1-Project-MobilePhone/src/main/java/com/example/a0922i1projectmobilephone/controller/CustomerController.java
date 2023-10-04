package com.example.a0922i1projectmobilephone.controller;
import com.example.a0922i1projectmobilephone.entity.Customer;
import com.example.a0922i1projectmobilephone.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CustomerController {
   @Autowired
    private ICustomerService customerService;
    @RequestMapping(path = "/api/customers", method = RequestMethod.GET)
    public ResponseEntity<?> searchCustomer(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(required = false) String option,
                                            @RequestParam(required = false) String search,
                                            @RequestParam(required = false) String numberPhone){
        Page<Customer> customers = customerService.listCustomers(page, option, search, numberPhone);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
