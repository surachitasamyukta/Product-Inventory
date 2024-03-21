package com.controller;

import com.model.ProductMongoDB;
import com.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Product Inventory Api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    @Operation(summary = "Api to add a product")
    public String add(@RequestBody ProductMongoDB product) {
        return productService.add(product);
    }

    @GetMapping("/productById/{pid}")
    @Operation(summary = "Api to get a product by Id")
    //@PreAuthorize("hasAuthority('USER')")
    public ProductMongoDB getProductById(@PathVariable Integer pid) throws Exception {
        return productService.getProductById(pid);
    }


    @PutMapping("/update")
    @Operation(summary = "Api to update a product")
    public String updateProduct(@RequestBody ProductMongoDB product) {
        return productService.update(product);
    }

    @DeleteMapping("/delete/{pid}")
    @Operation(summary = "Api to delete a product")
    public String deleteProductById(@PathVariable Integer pid) {
        return productService.deleteById(pid);
    }

    @GetMapping("/allProductsByPage")
   // @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Api to get product list with pagination")
    public Page<ProductMongoDB> getAllProductsByPage(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        return productService.getProductsByPage(page, size);
    }


    @GetMapping("/allProducts")
    @Operation(summary = "Api to list of all product")
    public List<ProductMongoDB> getAllProducts() {

        String s = "";
        char[] c = s.toCharArray();
        int[] count = new int[4];
        return productService.getProducts();
    }



    @GetMapping("/filter/{status}")
    @Operation(summary = "Api to get products filtered by status ")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<ProductMongoDB> getAllProducts(@PathVariable String status) {
        return productService.getProductsByStatus(status);
    }

}
