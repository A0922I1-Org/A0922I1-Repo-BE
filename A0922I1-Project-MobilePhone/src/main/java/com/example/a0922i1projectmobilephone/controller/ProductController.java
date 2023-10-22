package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.dto.ProductDto;
import com.example.a0922i1projectmobilephone.entity.Product;
import com.example.a0922i1projectmobilephone.service.IProductService;
import com.example.a0922i1projectmobilephone.service.impl.ProductServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Integer idProduct) {
        Product product = productService.findById(idProduct);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value ="/create-product" ,method = RequestMethod.POST)
    public ResponseEntity<Product> createProduct(@Validated @RequestBody ProductDto productDto,
                                           BindingResult bindingResult) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.createProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

    }

    @PatchMapping("/edit-product/{productId}")
    public ResponseEntity<?> editProduct(@Validated @RequestBody ProductDto productDto,
                                         BindingResult bindingResult,
                                         @PathVariable Integer productId) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            Product product = productService.findById(productId);
            BeanUtils.copyProperties(productDto, product);
            productService.editProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
