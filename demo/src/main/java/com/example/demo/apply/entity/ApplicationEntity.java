package com.example.demo.apply.entity;

import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.entity.PostEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "application")
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private UserEntity applicant;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Column(length = 50)
    private String status;

    @Column(name = "applied_at", nullable = false)
    private LocalDateTime appliedAt;

    public ApplicationEntity() {}

    public ApplicationEntity(UserEntity applicant, PostEntity post, String status, LocalDateTime appliedAt) {
        this.applicant = applicant;
        this.post = post;
        this.status = status;
        this.appliedAt = appliedAt;
    }

    public Long getApplicationId() { return applicationId; }
    public void setApplicationId(Long applicationId) { this.applicationId = applicationId; }
    public UserEntity getApplicant() { return applicant; }
    public void setApplicant(UserEntity applicant) { this.applicant = applicant; }
    public PostEntity getPost() { return post; }
    public void setPost(PostEntity post) { this.post = post; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getAppliedAt() { return appliedAt; }
    public void setAppliedAt(LocalDateTime appliedAt) { this.appliedAt = appliedAt; }
}
