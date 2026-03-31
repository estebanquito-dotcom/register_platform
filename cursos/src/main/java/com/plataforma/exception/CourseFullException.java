package com.plataforma.exception;

public class CourseFullException extends RuntimeException{

    public CourseFullException(String mensaje){
        super(mensaje);
    }

}
