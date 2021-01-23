package com.rest.implementation;

import com.rest.entity.Product;
import com.rest.repository.ProductRepository;
import com.rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> deleteProduct(long id) {
        productRepository.deleteById(id);
        return getProducts();
    }

    @Override
    public List<Product> updateProduct(long id, Product product) {
        Product obj = productRepository.findById(id).get();
        obj.setName(product.getName());
        productRepository.save(obj);
        return getProducts();
    }

    @Override
    public List<Product> createProduct(Product product) {
        productRepository.save(product);
        return getProducts();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).get();
    }
}
