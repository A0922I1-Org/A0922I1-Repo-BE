package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.service.IBrandService;
import com.example.a0922i1projectmobilephone.service.ICategoryService;
import com.example.a0922i1projectmobilephone.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private ICategoryService categoryService;

//    @GetMapping("/product/list")
//    private ResponseEntity<Page<Product>> showProductLists(Model model,
//                                                           @RequestParam("page") Optional<Integer> page,
//                                                           @RequestParam("size") Optional<Integer> size) {
//        Integer currentPage = page.orElse(1);
//        Integer pageSize = size.orElse(8);
//        model.addAttribute("currentPage", currentPage);
//        Page<Product> products = productService.findAllProducts(PageRequest.of(currentPage - 1, pageSize));
//        if (products.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Integer idProduct) {
        Product product = productService.findProductById(idProduct);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") Integer idProduct) {
        boolean deletedProduct = productService.deleteProductById(idProduct);
        if (deletedProduct) {
            return new ResponseEntity<>(Collections.singletonMap("message", "Delete product successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/search")
    public ResponseEntity<Page<Product>> searchProducts(
            Model model,
            @RequestParam("brandName") String brandName,
            @RequestParam("sellingPrice") String sellingPrice,
            @RequestParam("productName") String productName,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(8);
        model.addAttribute("currentPage", currentPage);
        Page<Product> products = productService.searchProducts(brandName, sellingPrice, productName, PageRequest.of(currentPage-1, pageSize));
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
