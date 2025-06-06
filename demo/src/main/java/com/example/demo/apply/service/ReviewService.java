package com.example.demo.apply.service;

import com.example.demo.apply.entity.ReviewEntity;
import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.respository.ReviewRespository;
import com.example.demo.apply.respository.UserRespository;
import com.example.demo.apply.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReviewService {

    @Autowired private ReviewRespository reviewRepository;
    @Autowired private UserRespository userRepository;
    @Autowired private FileUtil fileUtil;

    public List<ReviewEntity> getAllReviews() {
        return reviewRepository.findAll();
    }

    public ReviewEntity getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 없습니다: " + reviewId));
    }

    public ReviewEntity addReview(Long targetUserId, Long reviewerId, Integer rating,
                                  String content, MultipartFile photoFile) throws Exception {
        UserEntity target = userRepository.findById(targetUserId).orElseThrow();
        UserEntity reviewer = userRepository.findById(reviewerId).orElseThrow();


        ReviewEntity review = new ReviewEntity();
        review.setTargetUser(target);
        review.setReviewer(reviewer);
        review.setRating(rating);
        review.setContent(content);
        review.setCreatedAt(LocalDate.now());

        if (photoFile != null && !photoFile.isEmpty()) {
            String path = fileUtil.saveFile(photoFile, "reviews");
            review.setPhotoPath(path);
        }

        return reviewRepository.save(review);
    }


}
