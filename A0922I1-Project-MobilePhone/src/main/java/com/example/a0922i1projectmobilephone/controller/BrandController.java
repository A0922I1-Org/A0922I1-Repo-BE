package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.entity.Brand;
import com.example.a0922i1projectmobilephone.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BrandController {
    @Autowired
        private IBrandService brandService;
    @GetMapping("/list")
    public ResponseEntity<List<Brand>> getAllBrand() {
        List<Brand> brandList = brandService.getAllBrand();
        if (brandList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(brandList, HttpStatus.OK);
    }
}
