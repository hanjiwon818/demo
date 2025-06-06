package com.example.demo.apply.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(length = 100, nullable = false)
    private String name;

    public CategoryEntity() {}

    public CategoryEntity(String name) {
        this.name = name;
    }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
