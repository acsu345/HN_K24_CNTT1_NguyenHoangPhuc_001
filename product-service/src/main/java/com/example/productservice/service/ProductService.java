package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @PostConstruct
    public void initData() {
        if (productRepository.count() == 0) {
            productRepository.save(new Product(null, "iPhone", 25000000.0, 2L));
            productRepository.save(new Product(null, "MacBook", 30000000.0, 1L));
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
