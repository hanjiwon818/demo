package com.example.demo.apply.action;

import com.example.demo.apply.entity.CategoryEntity;
import com.example.demo.apply.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryAction {

    @Autowired
    private CategoryService categoryService;

    public List<CategoryEntity> executeGetAll() {
        return categoryService.getAllCategories();
    }

    public CategoryEntity executeSave(CategoryEntity categoryEntity) {
        return categoryService.saveCategory(categoryEntity);
    }
}
