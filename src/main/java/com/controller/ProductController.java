package com.controller;

import com.model.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    /*@GetMapping("/search/id")
    public String getProductById(String id) {
        return "";
    }

    @DeleteMapping("/delete/id")
    public String deleteProductById(String id) {
        return "product deleted";
    }

    @PostMapping("/update/id")
    public String updateProduct(String id) {
        return "Product updated";
    }*/
}
