package com.example.demo.apply.respository;

import com.example.demo.apply.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

}
