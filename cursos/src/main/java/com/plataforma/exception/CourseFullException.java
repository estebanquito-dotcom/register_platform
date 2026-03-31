package com.plataforma.exception;

public class CourseFullException extends RuntimeException{

    public CourseFullException(String message){
        super(message);
    }

}
