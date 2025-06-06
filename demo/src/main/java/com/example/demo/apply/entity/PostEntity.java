package com.example.demo.apply.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "media_path", length = 255)
    private String mediaPath;

    public PostEntity() {}

    public PostEntity(UserEntity author, CategoryEntity category, String title, String content, LocalDate createdAt, String mediaPath) {
        this.author = author;
        this.category = category;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.mediaPath = mediaPath;
    }

    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId; }
    public UserEntity getAuthor() { return author; }
    public void setAuthor(UserEntity author) { this.author = author; }
    public CategoryEntity getCategory() { return category; }
    public void setCategory(CategoryEntity category) { this.category = category; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
    public String getMediaPath() { return mediaPath; }
    public void setMediaPath(String mediaPath) { this.mediaPath = mediaPath; }
}
