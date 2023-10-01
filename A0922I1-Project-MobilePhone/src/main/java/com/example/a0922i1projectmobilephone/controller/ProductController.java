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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/product/list")
    private ResponseEntity<Map<String, Object>> showProductLists(Model model,
                                                                 @RequestParam("page") Optional<Integer> page,
                                                                 @RequestParam("size") Optional<Integer> size) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);
        model.addAttribute("currentPage", currentPage);
        Page<Product> products = productService.findAllProducts(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products", products);
        int totalPages = products.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
        }
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("products", products);
        responseBody.put("pageNumbers", model.asMap().get("pageNumbers"));
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findProductById (@PathVariable("id")Integer idProduct) {
        Product product = productService.findProductById(idProduct);
        if (product==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProductById (@PathVariable("id")Integer idProduct) {
        boolean deletedProduct = productService.deleteProductById(idProduct);
        if (deletedProduct) {
            return new ResponseEntity<>("Delete product successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/search")
    public ResponseEntity<Map<String, Object>> searchProducts(
            Model model,
            @RequestParam(name = "brandName", required = false) String brandName,
            @RequestParam(name = "sellingPrice", required = false) String sellingPrice,
            @RequestParam(name = "productName", required = false) String productName,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size) {
        Page<Product> products = productService.searchProducts(brandName, sellingPrice, productName, PageRequest.of(page - 1, size));
        model.addAttribute("products", products);
        int totalPages = products.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
        }
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("products", products);
        responseBody.put("pageNumbers", model.asMap().get("pageNumbers"));
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
