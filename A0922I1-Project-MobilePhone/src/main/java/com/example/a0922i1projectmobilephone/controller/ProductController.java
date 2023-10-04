package com.example.a0922i1projectmobilephone.controller;
import com.example.a0922i1projectmobilephone.entity.Customer;
import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
//    @RequestMapping(path = "/api/products", method = RequestMethod.GET)
//    public ResponseEntity<?> getAllProduct(@RequestParam(defaultValue = "0") int page){
////        Page<Product> products = iProductService.(page);
////        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
}
