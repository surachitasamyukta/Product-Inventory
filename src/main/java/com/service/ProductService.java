package com.service;

import com.dao.ProductRepositoryMongoDB;
import com.model.ProductMongoDB;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepositoryMongoDB repository;

    public List<ProductMongoDB> getProducts() {
        return repository.findAll();
    }


    public List<ProductMongoDB> getProductsByStatus(String status) {
        return repository.findAll().stream().filter(product -> product.getStatus().name().equals(status)).collect(Collectors.toList());

    }

    public String add(ProductMongoDB product) {
        List<ProductMongoDB> products = getProducts();
        if (products.stream().anyMatch(existingProduct -> product.getName().equals(existingProduct.getName()))) {
            return "Product exists";
        } else {
            product.setProductId(new Random().nextInt());
            product.setStatus(product.getQuantity() < 1 ? ProductMongoDB.Status.OUT_OF_STOCK : ProductMongoDB.Status.AVAILABLE);
            repository.save(product);
            return "Product added";
        }
    }

    public ProductMongoDB getProductById(Integer id) throws Exception {
        List<ProductMongoDB> products = getProducts();
        Optional<ProductMongoDB> productById = products.stream().filter(product -> product.getProductId().equals(id)).findAny();
        if (productById.isPresent()) {
            return productById.get();
        } else {
            throw new Exception("productId not found");
        }
    }

    public String update(ProductMongoDB product) {
        List<ProductMongoDB> products = getProducts();
        if (products.stream().anyMatch(existingProduct -> product.getName().equals(existingProduct.getName()))) {
            product.setStatus(product.getQuantity() < 1 ? ProductMongoDB.Status.OUT_OF_STOCK : ProductMongoDB.Status.AVAILABLE);
            repository.save(product);
            return "product updated";
        } else {
            return "Product not found";
        }
    }


    public String deleteById(Integer pid) {
        ObjectId productId = null;
        List<ProductMongoDB> products = getProducts();
        Optional<ProductMongoDB> product = products.stream().filter(prduct -> prduct.getProductId().equals(pid)).findAny();
        if (product.isPresent()) {
            productId = product.get().getId();
            repository.deleteById(productId);
            return "Product deleted";
        }
        throw new IllegalArgumentException("productId not found");
    }


    public Page<ProductMongoDB> getProductsByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }
}
