package com.plataforma.exception;

public class NotFoundException extends RuntimeException{

    NotFoundException(String mensaje){
        super(mensaje);
    }

}
