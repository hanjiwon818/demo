package com.example.demo.apply.service;

import com.example.demo.apply.entity.CommentEntity;
import com.example.demo.apply.respository.CommentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRespository commentRepository;

    public List<CommentEntity> getAllComments() {
        return commentRepository.findAll();
    }

    public CommentEntity addComment(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }
}
