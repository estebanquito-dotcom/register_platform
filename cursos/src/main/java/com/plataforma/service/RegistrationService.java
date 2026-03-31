package com.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.plataforma.exception.CourseFullException;
import com.plataforma.exception.StudentNotFoundException;
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

    
    //list registrations or courses by student, by id.
    //the problem here is, the header realease before the exception, but this was own idea, absolutely.
    public void listRegistrationsByStudent(int id){
        boolean found= false;
        int count=1;
        logger.info("Searching Student Registrations by ID"+id);
        System.out.println("Registrations For Student ID: "+id);
        for(Registration registration : registrations){
            if(registration.getStudent().getId()==id){
                System.out.println(count+". - "+registration.getCourse().getName());
                found=true;
                count++;
            }
        }

        if(!found){
            String error="The student indetify by ID: "+id+" doesnt exist";
            logger.warn(error);
            throw new StudentNotFoundException(error);

        }
        

    }

    //in this case AI advices, casue i hadnt though this way to dont show the header before the exception.
    public void listRegistrationsByStudentByList(int id){
        List<String> registrationsFound = new ArrayList<>();

        for(Registration registration: registrations){
            if(registration.getStudent().getId()==id){
                registrationsFound.add(registration.getCourse().getName());
            }
        }
        if(registrationsFound.isEmpty()){
            String error = "The student indetify by ID: "+id+" doesnt exist";
            logger.warn(error);
            throw new StudentNotFoundException(error);
        }
        System.out.println("Showing Courses for Student ID: " + id);
        for(int i=0;i<=registrationsFound.size();i++){
            System.out.println((i+1)+". -"+registrationsFound.get(i));
        }
    }



    

}
