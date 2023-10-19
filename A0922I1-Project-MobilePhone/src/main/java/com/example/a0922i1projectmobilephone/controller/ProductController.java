package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable(value = "id", required = false) Integer idProduct) {
        Product product = iProductService.findProductById(idProduct);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable(value = "id", required = false) Integer idProduct) {
        boolean deletedProduct = iProductService.deleteProductById(idProduct);
        if (deletedProduct) {
            return new ResponseEntity<>(Collections.singletonMap("message", "Delete product successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/list")
    public ResponseEntity<Page<Product>> getProductList(
            Model model,
            @RequestParam("brandName") Optional<String> brand,
            @RequestParam("sellingPrice") Optional<String> price,
            @RequestParam("productName") Optional<String> name,
            @RequestParam("productCpu") Optional<String> cpu,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @RequestParam("sort") Optional<String> sort,
            @RequestParam("direction") Optional<Boolean> direction) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(8);
        String brandName = brand.orElse(null);
        String sellingPrice = price.orElse(null);
        String productName = name.orElse(null);
        String productCpu = cpu.orElse(null);
        String sortField = sort.orElse("product_id");
        Boolean directionSort = direction.orElse(true);
        model.addAttribute("currentPage", currentPage);
        Page<Product> products;
        if (directionSort) {
            products = iProductService.getProductList(brandName, sellingPrice, productName, productCpu, PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        } else {
            products = iProductService.getProductList(brandName, sellingPrice, productName, productCpu, PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).descending()));
        }
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
