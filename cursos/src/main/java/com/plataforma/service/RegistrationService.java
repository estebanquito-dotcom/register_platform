package com.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.plataforma.model.Course;
import com.plataforma.model.Registration;
import com.plataforma.model.Student;

public class RegistrationService {

    private static final Logger logger = LogManager.getLogger(RegistrationService.class);
    private List<Registration> registrations;

    public RegistrationService (){
        logger.info("RegistrationService Initialized");
        this.registrations = new ArrayList<>(); 
    }

    public void RegisterStudent(Course course,Student student){
        Registration registration = new Registration(course, student);
        registrations.add(registration);
    }

}
