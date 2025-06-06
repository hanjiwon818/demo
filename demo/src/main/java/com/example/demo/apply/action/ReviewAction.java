package com.example.demo.apply.action;

import com.example.demo.apply.entity.ReviewEntity;
import com.example.demo.apply.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class ReviewAction {

    @Autowired
    private ReviewService reviewService;

    public List<ReviewEntity> viewAllReviews() {
        return reviewService.getAllReviews();
    }

    public ReviewEntity createReview(Long targetUserId, Long reviewerId,
                                     Integer rating, String content,
                                     MultipartFile photoFile) throws Exception {
        return reviewService.addReview(targetUserId, reviewerId, rating, content, photoFile);
    }

    public void registerReview(Long targetUserId, Long reviewerId, Integer rating, String content, MultipartFile photoFile) throws Exception {
        reviewService.addReview(targetUserId, reviewerId, rating, content, photoFile);
    }

}
