package com.plataforma.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.plataforma.exception.CourseFullException;
import com.plataforma.exception.NotFoundException;

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


    //register students method
    public void registerStudent(Student student, Course course){
        if(!course.isFull()){
            Registration registration = new Registration(course, student);
            registrations.add(registration);
            registration.getCourse().addStudent(student);
            logger.info("The Student: "+student.getName()+" has been registered succesfully: "+course.getName());
            return;
        }
        String error = "The course: "+course.getName()+" is full";
        logger.warn(error);
        throw new CourseFullException(error);
            
    }

    
    //list registrations or  by student,
    public List<Registration> listRegistrationsByStudent(Student student){
        
        List<Registration> studentRegistrations = new ArrayList<>();

        for(Registration registration: registrations){
            if(registration.getStudent().getId()==student.getId()){
                studentRegistrations.add(registration);
            }
        }

        if(studentRegistrations.isEmpty()){
            String error = "The student identify by ID: "+student.getId() +"doesnt have any registration in system";
            logger.warn(error);
            throw new NotFoundException(error);
        }

        return studentRegistrations;

    }


    

}
