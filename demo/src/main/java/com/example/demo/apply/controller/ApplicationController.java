package com.example.demo.apply.controller;

import com.example.demo.apply.action.ApplicationAction;
import com.example.demo.apply.entity.ApplicationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationAction applicationAction;

    @GetMapping
    public List<ApplicationEntity> getAllApplications() {
        return applicationAction.viewAllApplications();
    }

    @PostMapping
    public ApplicationEntity addApplication(@RequestBody ApplicationEntity application) {
        return applicationAction.createApplication(application);
    }
}
