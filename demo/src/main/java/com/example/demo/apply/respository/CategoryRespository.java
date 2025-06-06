package com.example.demo.apply.respository;

import com.example.demo.apply.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<CategoryEntity, Long> {
}
