package com.example.demo.apply.controller;

import com.example.demo.apply.action.PostAction;
import com.example.demo.apply.entity.PostEntity;
import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.service.CategoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostAction postAction;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllPosts(Model model) {
        List<PostEntity> posts = postAction.viewAllPosts();
        model.addAttribute("posts", posts);
        return "post-list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model, HttpSession session) {
        Map<String, Object> form = postAction.preparePostForm(session);
        model.addAllAttributes(form);
        return "write";
    }

/*    @PostMapping
    public String addPost(@ModelAttribute PostEntity post,
                          @RequestParam("category") Long categoryId,
                          @RequestParam(value = "mediaFile", required = false) MultipartFile mediaFile,
                          HttpSession session) throws Exception {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        if (loginUser == null) return "redirect:/login";

        postAction.registerPost(post, categoryId, mediaFile, loginUser);
        return "redirect:/posts";
    }*/

    @PostMapping
    public String addPost(@ModelAttribute PostEntity post,
                          @RequestParam("category") Long categoryId,
                          @RequestParam(value = "mediaFile", required = false) MultipartFile mediaFile,
                          HttpSession session) throws Exception {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        if (loginUser == null) return "redirect:/login";

        postAction.registerPost(post, categoryId, mediaFile, loginUser);

        // ★ 카테고리명 조회 (categoryId → categoryName)
        String categoryName = categoryService.findNameById(categoryId);

        // ★ 카테고리 페이지로 리다이렉트
        return "redirect:/category?category=" + URLEncoder.encode(categoryName, "UTF-8");
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, HttpSession session, Model model) {
        Map<String, Object> form = postAction.prepareEditForm(id);
        model.addAllAttributes(form);
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        return "edit-post";
    }

    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable Long id,
                             @ModelAttribute PostEntity post,
                             @RequestParam("category") Long categoryId,
                             @RequestParam(value = "mediaFile", required = false) MultipartFile mediaFile) throws Exception {
        postAction.updatePost(id, post, categoryId, mediaFile);
        //수정해야됨

        return "redirect:/category?category=" + categoryId;

    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postAction.deletePost(id);
        return "redirect:/users/mypage";
    }

/*    @GetMapping("/{id}")
    public String getPostDetail(@PathVariable Long id, Model model) {
        model.addAttribute("post", postAction.viewPost(id));
        return "post";
    }*/

    @GetMapping("/{id}")
    public String getPostDetail(@PathVariable Long id, Model model, HttpSession session) {
        model.addAttribute("post", postAction.viewPost(id));
        model.addAttribute("loginUser", session.getAttribute("loginUser"));
        return "post";
    }

}
