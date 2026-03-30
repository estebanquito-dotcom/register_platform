package com.plataforma.model;



public class Course {

    //attributes
    private String code;
    private String name;
    private String capacity;
    
    //constructor
    public Course(String code, String name, String capacity) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
    }
    
    //methods
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }


    

}
