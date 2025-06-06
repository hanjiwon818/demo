package com.example.demo.apply.controller;

import com.example.demo.apply.action.ReviewAction;
import com.example.demo.apply.entity.ReviewEntity;
import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewAction reviewAction;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/new")
    public String showReviewForm(@RequestParam("targetUserId") Long targetUserId, Model model, HttpSession session) {
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        model.addAttribute("targetUserId", targetUserId);
        model.addAttribute("reviewerId", loginUser.getId());
        return "write-review";
    }

    @PostMapping
    public String addReview(
            @RequestParam("targetUserId") Long targetUserId,
            @RequestParam("reviewerId") Long reviewerId,
            @RequestParam("rating") Integer rating,
            @RequestParam("content") String content,
            @RequestParam(value = "photoFile", required = false) MultipartFile photoFile
    ) throws Exception {
        reviewAction.registerReview(targetUserId, reviewerId, rating, content, photoFile);
        return "redirect:/users/" + targetUserId;
    }

    @GetMapping("/{reviewId}")
    public String showReviewDetail(@PathVariable Long reviewId, Model model) {
        ReviewEntity review = reviewService.getReviewById(reviewId);
        model.addAttribute("review", review);
        return "post-review"; // templates/post-review.html
    }


}
