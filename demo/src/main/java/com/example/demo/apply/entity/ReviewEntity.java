package com.example.demo.apply.entity;

import com.example.demo.apply.entity.UserEntity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private UserEntity reviewer;

    @ManyToOne
    @JoinColumn(name = "target_user_id")
    private UserEntity targetUser;

    @Column(nullable = false)
    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "photo_path")
    private String photoPath;

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public ReviewEntity() {}

    public ReviewEntity(UserEntity reviewer, UserEntity targetUser, Integer rating, String content, LocalDate createdAt) {
        this.reviewer = reviewer;
        this.targetUser = targetUser;
        this.rating = rating;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId;}
    public UserEntity getReviewer() { return reviewer; }
    public void setReviewer(UserEntity reviewer) { this.reviewer = reviewer; }
    public UserEntity getTargetUser() { return targetUser; }
    public void setTargetUser(UserEntity targetUser) { this.targetUser = targetUser; }
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    }
