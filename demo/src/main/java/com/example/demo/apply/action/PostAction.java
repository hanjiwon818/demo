package com.example.demo.apply.action;

import com.example.demo.apply.entity.PostEntity;
import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.respository.CategoryRespository;
import com.example.demo.apply.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class PostAction {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryRespository categoryRespository;

    public List<PostEntity> viewAllPosts() {
        return postService.getAllPosts();
    }

    public PostEntity viewPost(Long id) {
        return postService.getPostById(id).orElseThrow();
    }

    public Map<String, Object> preparePostForm(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        map.put("post", new PostEntity());
        map.put("categories", categoryRespository.findAll());
        map.put("loginUser", session.getAttribute("loginUser"));
        return map;
    }

    public Map<String, Object> prepareEditForm(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("post", viewPost(id));
        map.put("categories", categoryRespository.findAll());
        return map;
    }

    public void registerPost(PostEntity post, Long categoryId, MultipartFile file, UserEntity loginUser) throws Exception {
        postService.register(post, categoryId, file, loginUser);
    }

    public void updatePost(Long id, PostEntity post, Long categoryId, MultipartFile file) throws Exception {
        postService.update(id, post, categoryId, file);
    }

    public void deletePost(Long id) {
        postService.delete(id);
    }
}
