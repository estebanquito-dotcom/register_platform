package com.plataforma.service;

import java.util.ArrayList;
import java.util.List;



import org.apache.logging.log4j.*;

import com.plataforma.exception.CourseFullException;
import com.plataforma.exception.NotFoundException;
import com.plataforma.model.Course;

public class CourseService {

    private static final Logger logger = LogManager.getLogger();
    private List <Course> courses;

    public CourseService(){
        logger.info("CursoService Initialized");
        this.courses = new ArrayList<>();
    }

    //create course method; name;code; and capacity.
    public void addCourse(String code, String name,int capacity){
        for(Course course : courses){
            if(course.getCode().equals(code)){
                String error = "Course by code "+code+" already exist, verify code, please";
                logger.warn(error);
                throw new CourseFullException(error);
            }
        }

        Course newCourse = new Course(code,name,capacity);
        courses.add(newCourse);
        logger.info("Curso: "+name+" created succefully");

    }



    //list available courses /if isnt full
    public List<Course> listAvailableCourses(){
        List<Course> availableCourses = new ArrayList<>();

        for(Course course: courses){
            if(!course.isFull()){
                availableCourses.add(course);
            }
        }

        if(availableCourses.isEmpty()){
            String error = "All Courses are Full";
            logger.warn(error);
            throw new CourseFullException(error);
        }

        return availableCourses;
    }



    //to search course by code
    public Course searchCourseByCode(String code){
        for(Course course : courses){
            if(course.getCode().equals(code)){
                return course;
            }
        }

        String error = "The course by Code: "+code+" not Found";
        logger.warn(error);
        throw new NotFoundException(error);
    }

    //set capacity at course if they want to modify
    public void controllcapacity(Course course, int newCapacity){
        logger.info("course :" +course.getName()+" being modify, current capacity :"+course.getCapacity());
        course.setCapacity(newCapacity);
        logger.info("the course: "+course.getName()+"has modified succesfully: new capacity: "+newCapacity);
    }



}
