package com.rest2.controller;


import com.rest2.entity.Product;
import com.rest2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Product getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/products")
    public @ResponseBody
    List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public @ResponseBody
    List<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    List<Product> deleteProduct(@PathVariable("id") long id) {
        return productService.deleteProduct(id);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    List<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

}
