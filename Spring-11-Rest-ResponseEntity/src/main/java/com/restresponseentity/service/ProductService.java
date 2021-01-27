package com.restresponseentity.service;

import com.restresponseentity.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    List<Product> deleteProduct(long id);

    List<Product> updateProduct(long id, Product product);

    List<Product> createProduct(Product product);

    Product getProduct(long id);

}
