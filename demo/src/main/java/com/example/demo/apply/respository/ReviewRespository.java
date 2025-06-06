package com.example.demo.apply.respository;

import com.example.demo.apply.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRespository extends JpaRepository<ReviewEntity, Long> {
//    List<ReviewEntity> findByTargetUser_Id(Integer targetUserId);

    List<ReviewEntity> findByTargetUser_Id(Long targetUserId);
}
