package com.plataforma.model;

import java.time.LocalDate;


public class Registration {

    //Attributes
    private Course course;
    private Student student;
    private LocalDate date;

    //Constructor
    public Registration(Course course, Student student) {
        this.course = course;
        this.student = student;
        this.date = LocalDate.now();
    }

    //Methods
    public Course getCourse() {
        return course;
    }



    public Student getStudent() {
        return student;
    }



    public LocalDate getDate() {
        return date;
    }




    






    




    

}
