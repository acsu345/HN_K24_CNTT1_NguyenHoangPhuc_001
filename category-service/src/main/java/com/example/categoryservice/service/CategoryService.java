package com.example.categoryservice.service;

import com.example.categoryservice.entity.Category;
import com.example.categoryservice.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @PostConstruct
    public void initData() {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category(null, "Laptop", "Các sản phẩm máy tính xách tay"));
            categoryRepository.save(new Category(null, "Phone", "Các sản phẩm điện thoại di động"));
        }
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}
