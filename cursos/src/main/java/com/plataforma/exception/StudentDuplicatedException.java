package com.plataforma.exception;

public class StudentDuplicatedException extends RuntimeException{

    public StudentDuplicatedException(String message){
        super(message);
    }

}
