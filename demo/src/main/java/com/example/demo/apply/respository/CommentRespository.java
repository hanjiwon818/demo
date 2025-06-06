package com.example.demo.apply.respository;

import com.example.demo.apply.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRespository extends JpaRepository<CommentEntity, Long> {
}
