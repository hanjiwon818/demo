package com.example.demo.apply.action;

import com.example.demo.apply.entity.ApplicationEntity;
import com.example.demo.apply.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationAction {

    @Autowired
    private ApplicationService applicationService;

    public List<ApplicationEntity> viewAllApplications() {
        return applicationService.getAllApplications();
    }

    public ApplicationEntity createApplication(ApplicationEntity application) {
        return applicationService.addApplication(application);
    }
}
