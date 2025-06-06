package com.example.demo.apply.controller;

import com.example.demo.apply.action.CommentAction;
import com.example.demo.apply.entity.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentAction commentAction;

    @GetMapping
    public List<CommentEntity> getAllComments() {
        return commentAction.viewAllComments();
    }

    @PostMapping
    public CommentEntity addComment(@RequestBody CommentEntity comment) {
        return commentAction.createComment(comment);
    }
}
