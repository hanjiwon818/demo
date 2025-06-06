package com.example.demo.apply.service;

import com.example.demo.apply.entity.CategoryEntity;
import com.example.demo.apply.respository.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRepository;

    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    // ★ 추가: 카테고리 id로 카테고리명 조회
    public String findNameById(Long categoryId) {
        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 없습니다: " + categoryId));
        return category.getName();
    }


}
