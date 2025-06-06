package com.example.demo.apply.respository;

import com.example.demo.apply.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRespository extends JpaRepository<ApplicationEntity, Long> {
}
