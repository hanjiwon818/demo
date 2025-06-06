package com.example.demo.apply.controller;

import com.example.demo.apply.action.CategoryAction;
import com.example.demo.apply.entity.CategoryEntity;
import com.example.demo.apply.entity.PostEntity;
import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryAction categoryAction;

    @Autowired
    private PostService postService;

    @GetMapping("/categories")
    public List<CategoryEntity> getAllCategories() {
        return categoryAction.executeGetAll();
    }

    @PostMapping("/categories")
    public CategoryEntity addCategory(@RequestBody CategoryEntity categoryEntity) {
        return categoryAction.executeSave(categoryEntity);
    }

    //카테고리별 게시글 목록 추가
    @GetMapping("/users/category")
    public String showCategory(@RequestParam String category, Model model) {
        List<PostEntity> posts = postService.getPostsByCategory(category);
        model.addAttribute("posts", posts);
        model.addAttribute("category", category);
        return "category"; // templates/category.html
    }

}
*/
@Controller
public class CategoryController {

    @Autowired
    private CategoryAction categoryAction;

    @Autowired
    private PostService postService;


    @GetMapping("/categories")
    @ResponseBody // 이 메서드만 JSON 반환
    public List<CategoryEntity> getAllCategories() {
        return categoryAction.executeGetAll();
    }

    @PostMapping("/categories")
    @ResponseBody // 이 메서드만 JSON 반환
    public CategoryEntity addCategory(@RequestBody CategoryEntity categoryEntity) {
        return categoryAction.executeSave(categoryEntity);
    }

    @GetMapping("/category")
    public String showCategory(@RequestParam String category, HttpSession session, Model model) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("category", category);

        // 게시글 목록도 같이 model에 담기 (예시)
        List<PostEntity> posts = postService.getPostsByCategory(category);
        model.addAttribute("posts", posts);

        return "category"; // templates/category.html
    }



    // 카테고리별 게시글 목록 (HTML 렌더링)
//    @GetMapping("/users/category")
//    public String showCategory(@RequestParam String category, Model model) {
//        List<PostEntity> posts = postService.getPostsByCategory(category);
//        model.addAttribute("posts", posts);
//        model.addAttribute("category", category);
//        return "category"; // templates/category.html
//    }
}

