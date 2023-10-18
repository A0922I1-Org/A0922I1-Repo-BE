package com.example.a0922i1projectmobilephone.controller;
import com.example.a0922i1projectmobilephone.entity.Customer;
import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @RequestMapping(path = "/product", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProduct(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(required = false) String option,
                                           @RequestParam(required = false) String search,
                                           @RequestParam(required = false) String storage){
    Page<Product> products = iProductService.listProduct(page, option, search, storage);
    return new  ResponseEntity<> (products, HttpStatus.OK);
    }
    @RequestMapping(path = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findByIdProduct(@PathVariable(required = false) int id){
        Product product = iProductService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
