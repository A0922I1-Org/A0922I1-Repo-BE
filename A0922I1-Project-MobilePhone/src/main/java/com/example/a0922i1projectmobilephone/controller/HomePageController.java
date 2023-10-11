package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.service.homepage.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class HomePageController {
    @Autowired
    private HomePageService homePageService;

    //    @GetMapping
//    public Page<Product> getAllProducts(@PageableDefault(value = 3, sort = "productName", direction = Sort.Direction.ASC) Pageable pageable) {
//        return homePageService.showAll(pageable);
//    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = homePageService.showAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}