package com.example.demo.apply.entity;

import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.entity.PostEntity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    public CommentEntity() {}

    public CommentEntity(UserEntity author, PostEntity post, String content, LocalDate createdAt) {
        this.author = author;
        this.post = post;
        this.content = content;
        this.createdAt = createdAt;
    }

    // Getter & Setter
    public Integer getCommentId() { return commentId; }
    public UserEntity getAuthor() { return author; }
    public void setAuthor(UserEntity author) { this.author = author; }
    public PostEntity getPost() { return post; }
    public void setPost(PostEntity post) { this.post = post; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
}
