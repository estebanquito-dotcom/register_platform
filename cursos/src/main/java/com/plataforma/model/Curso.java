package com.plataforma.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String codigo;
    private String nombre;
    private int capacidad;
    private List<Estudiante> estudiantes;

    public Curso(String codigo,String nombre, int capacidad){
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estudiantes = new ArrayList<>();
    
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                ", estudiantes=" + estudiantes +
                '}';
}





}
