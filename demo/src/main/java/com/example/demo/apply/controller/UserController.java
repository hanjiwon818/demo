package com.example.demo.apply.controller;

import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.entity.PostEntity;
import com.example.demo.apply.entity.ReviewEntity;
import com.example.demo.apply.service.UserService;
import jakarta.servlet.http.HttpSession;
import com.example.demo.apply.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.apply.service.PostService;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

//    @GetMapping
//    public String getAllUsers(Model model, HttpSession session) {
//        List<UserEntity> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        model.addAttribute("loginUser", session.getAttribute("loginUser"));
//        return "main";
//    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "signup";
    }

    @PostMapping("/new")
    public String register(@ModelAttribute UserEntity user, Model model) {
        if (userService.getUserByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "이미 사용중인 이메일입니다.");
            return "signup";
        }
        userService.register(user);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        boolean success = userService.login(email, password, session);
        if (success) {
            return "redirect:/users/main";
        } else {
            model.addAttribute("error", "이메일 또는 비밀번호가 올바르지 않습니다.");
            return "login";
        }
    }

    @GetMapping("/main")
    public String showMainPage(HttpSession session, Model model) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        return "main";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        userService.logout(session);
        return "redirect:/users/main";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, HttpSession session, Model model) {
        UserEntity user = userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다: " + id));
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("user", user);
        return "edit-profile";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute UserEntity user, HttpSession session) {
        UserEntity updated = userService.updateUser(id, user);
        session.setAttribute("loginUser",updated);
        return "redirect:/users/mypage";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    //다른 사람 마이페이지
//    @GetMapping("/{id}")
//    public String getUserDetail(@PathVariable Long id, HttpSession session ,Model model) {
//        UserEntity user = userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다: " + id));
//        List<ReviewEntity> reviews = userService.getReviewsForUser(id);
//        List<PostEntity> posts = userService.getPostsByUser(id);
//        model.addAttribute("user", user);
//        model.addAttribute("reviews", reviews);
//        model.addAttribute("posts", posts);
//        return "yourpage";
//    }

    // 다른 사람 마이페이지 (프로필)
// 다른 사람 마이페이지(프로필)
    @GetMapping("/{id}")
    public String getUserDetail(@PathVariable Long id, Model model, HttpSession session) {
        UserEntity user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다: " + id));
        List<ReviewEntity> reviews = userService.getReviewsForUser(id);
        List<PostEntity> posts = userService.getPostsByUser(id);
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        model.addAttribute("user", user);         // 해당 유저 정보
        model.addAttribute("reviews", reviews);   // 해당 유저가 받은 리뷰
        model.addAttribute("posts", posts);       // 해당 유저가 쓴 게시글
        model.addAttribute("loginUser", loginUser); // 로그인한 내 정보(필요시)
        return "yourpage"; // 다른 사람 마이페이지 템플릿
    }

    //마이페이지 이동 추가
    @GetMapping("/mypage")
    public String showMyPage(HttpSession session, Model model) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        if (loginUser == null) {
            // 로그인 안 한 경우 로그인 페이지로 리다이렉트
            return "redirect:/users/login";
        }
        userService.getReviewsForUser(loginUser.getId());
        // ★ 내가 쓴 글 리스트 조회 및 모델에 추가 (여기에 추가!)
        List<ReviewEntity> reviews = userService.getReviewsForUser(loginUser.getId());
        List<PostEntity> myPosts = postService.getPostsByUser(loginUser.getId());
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("reviews", reviews);
        model.addAttribute("myPosts", myPosts);
        model.addAttribute("user", loginUser);
        return "/mypage"; // templates/mypage.html로 이동
    }

    @GetMapping("/{id}/write-review")
    public String showWriteReviewForm(@PathVariable Long id, Model model, HttpSession session) {

        UserEntity targetUser = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다: " + id));
        model.addAttribute("targetUser", targetUser);

        // (선택) 로그인한 사용자 정보도 필요하다면 추가
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/users/login"; // 로그인 페이지로 이동
        }
        model.addAttribute("loginUser", loginUser);


        return "write-review"; // src/main/resources/templates/write-review.html
    }



}
