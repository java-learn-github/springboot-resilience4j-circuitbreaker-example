package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo repository;

    public ProductServiceImpl(ProductRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }
}
