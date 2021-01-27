package com.rest2.controller;


import com.rest2.entity.Product;
import com.rest2.service.ProductService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") long id) {

        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts() {

        return productService.getProducts();
    }

    @PostMapping
    public List<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    public List<Product> deleteProduct(@PathVariable("id") long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping(value = "/{id}")
    public List<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

}
