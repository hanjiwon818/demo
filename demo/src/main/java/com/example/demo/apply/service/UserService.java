package com.example.demo.apply.service;

import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.entity.PostEntity;
import com.example.demo.apply.entity.ReviewEntity;
import com.example.demo.apply.respository.PostRespository;
import com.example.demo.apply.respository.ReviewRespository;
import com.example.demo.apply.respository.UserRespository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRespository userRepository;
    @Autowired
    private ReviewRespository reviewRepository;
    @Autowired
    private PostRespository postRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserEntity register(UserEntity user) {
        user.setCreatedAt(LocalDate.now());
        return userRepository.save(user);
    }


    public boolean login(String email, String password, HttpSession session) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            session.setAttribute("loginUser", userOpt.get());
            return true;
        }
        return false;
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }

    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        UserEntity existing = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다: " + id));
        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        existing.setPassword(updatedUser.getPassword());
//        existing.setCreatedAt(updatedUser.getCreatedAt());
        return userRepository.save(existing);
    }

    public UserEntity createUser(UserEntity user){  //
        // 회원 가입 후 데이터베이스에 새로 생성
        // 이메일 중복 확인
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        // 가입일 설정 (없을 경우)
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDate.now());
        }
        // 저장 및 반환
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<ReviewEntity> getReviewsForUser(Long userId) {
        return reviewRepository.findByTargetUser_Id(userId);
    }

   /* public List<PostEntity> getPostsByUser(Long userId) {
        return postRepository.findByAuthor_Id(userId);
    }*/
   public List<PostEntity> getPostsByUser(Long userId) {
       return postRepository.findByAuthor_Id(userId);
   }

}