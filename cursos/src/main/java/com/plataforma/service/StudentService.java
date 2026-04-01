package com.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.plataforma.exception.StudentDuplicatedException;
import com.plataforma.exception.StudentNotFoundException;
import com.plataforma.model.Student;

public class StudentService {
    private List<Student> students;
    private static final Logger logger = LogManager.getLogger(StudentService.class);

    public StudentService(){
        logger.info("StudentService Initialized");
        this.students = new ArrayList<>();
    }

    public void registerStudent(Student newStudent){
        for(Student student: students){
            if(newStudent.getId()==student.getId()){
                String error= "Student by code: "+newStudent.getId()+" already exist";
                logger.warn(error);
                throw new StudentDuplicatedException(error);
            }
        }
        students.add(newStudent);
        logger.info("Student: "+newStudent.getName()+" registered succesfully");
    }

    public Student searchStudentBycode(int id){
        for (Student student : students){
            if(student.getId()==id){
                return student;
            }
        }
        String error= "The student identify by ID: "+id+" theres no exist in the system";
        logger.warn(error);
        throw new StudentNotFoundException(error);
    }

}
