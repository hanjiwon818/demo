package com.example.demo.apply.action;

import com.example.demo.apply.entity.CommentEntity;
import com.example.demo.apply.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentAction {

    @Autowired
    private CommentService commentService;

    public List<CommentEntity> viewAllComments() {
        return commentService.getAllComments();
    }

    public CommentEntity createComment(CommentEntity commentEntity) {
        return commentService.addComment(commentEntity);
    }
}
