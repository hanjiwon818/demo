package com.example.demo.apply.service;

import com.example.demo.apply.entity.ApplicationEntity;
import com.example.demo.apply.respository.ApplicationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRespository applicationRespository;

    public List<ApplicationEntity> getAllApplications() {
        return applicationRespository.findAll();
    }

    public ApplicationEntity addApplication(ApplicationEntity application) {
        if (application.getAppliedAt() == null) {
            application.setAppliedAt(LocalDateTime.now());
        }
        return applicationRespository.save(application);
    }
}
