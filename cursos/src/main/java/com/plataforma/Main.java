package com.plataforma;

import org.apache.logging.log4j.*;

import com.plataforma.model.Course;
import com.plataforma.model.Student;
import com.plataforma.service.CourseService;
import com.plataforma.service.RegistrationService;



public class Main {


    

    private static final Logger logger = LogManager.getLogger(Main.class);
        
    public static void main(String[] args) {
        logger.info("Main Function Initialized");
        Student student1 = new Student("Paquito", 1, "paquito@gmail.com");
        Student student2 = new Student("Lucía", 2, "lucia.dev@gmail.com");
        Student student3 = new Student("Mateo", 3, "mateo.tech@gmail.com");
        Student student4 = new Student("Valeria", 4, "valeria.v@gmail.com");

        CourseService courseService = new CourseService();
        RegistrationService registrationService = new RegistrationService();

        Course javaBasic = new Course("1A", "Java Basic", 3);
        Course pythonIntermedium = new Course("2B", "Python Intermedium", 5);
        Course springBootExpert = new Course("3C", "Spring Boot Expert", 2);
        Course databaseSQL = new Course("4D", "Database SQL", 4);
        Course webVueJs = new Course("5E", "Web Development Vue.js", 6);

        registrationService.registerStudent(student1, webVueJs);
        registrationService.registerStudent(student2, webVueJs);
        registrationService.registerStudent(student3, javaBasic);
        registrationService.registerStudent(student4, javaBasic);






        

    }
}