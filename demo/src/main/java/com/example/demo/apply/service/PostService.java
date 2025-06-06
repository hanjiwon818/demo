package com.example.demo.apply.service;

import com.example.demo.apply.entity.PostEntity;
import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.respository.CategoryRespository;
import com.example.demo.apply.respository.PostRespository;
import com.example.demo.apply.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRespository postRepository;

    @Autowired
    private CategoryRespository categoryRepository;

    @Autowired
    private FileUtil fileUtil;

    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<PostEntity> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public List<PostEntity> getPostsByCategory(String category) {
        return postRepository.findByCategory_Name(category);
    }

    // 내가 쓴 글 리스트 조회(마이페이지)
    public List<PostEntity> getPostsByUser(Long userId){ return postRepository.findByAuthor_Id(userId); }


    public PostEntity register(PostEntity post, Long categoryId, MultipartFile file, UserEntity user) throws Exception {
        post.setAuthor(user);
        post.setCategory(categoryRepository.findById(categoryId).orElseThrow());
        post.setCreatedAt(LocalDate.now());

        if (file != null && !file.isEmpty()) {
            String path = fileUtil.saveFile(file, "posts");
            post.setMediaPath(path);
        }
        return postRepository.save(post);
    }

    public PostEntity update(Long id, PostEntity post, Long categoryId, MultipartFile file) throws Exception {
        PostEntity existing = getPostById(id).orElseThrow();
        existing.setTitle(post.getTitle());
        existing.setContent(post.getContent());
//        existing.setCategory(categoryRepository.findById(categoryId).orElseThrow());

        if (file != null && !file.isEmpty()) {
            String path = fileUtil.saveFile(file, "posts");
            existing.setMediaPath(path);
        }
        return postRepository.save(existing);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
