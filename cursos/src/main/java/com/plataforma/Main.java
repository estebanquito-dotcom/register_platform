package com.plataforma;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.plataforma.exception.CourseDuplicateException;
import com.plataforma.exception.CourseFullException;
import com.plataforma.exception.NotFoundException;
import com.plataforma.exception.StudentDuplicatedException;
import com.plataforma.exception.StudentNotFoundException;
import com.plataforma.model.Course;
import com.plataforma.model.Registration;
import com.plataforma.model.Student;
import com.plataforma.service.CourseService;
import com.plataforma.service.RegistrationService;
import com.plataforma.service.StudentService;



public class Main {

    private static Scanner entry = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Main.class);
    static Student student1 = new Student("Paquito", 1, "paquito@gmail.com");
    static Student student2 = new Student("Lucía", 2, "lucia.dev@gmail.com");
    static Student student3 = new Student("Mateo", 3, "mateo.tech@gmail.com");
    static Student student4 = new Student("Valeria", 4, "valeria.v@gmail.com");

    private static  CourseService courseService = new CourseService();
    private static  RegistrationService registrationService = new RegistrationService();
    private static StudentService studentService = new StudentService();
    

    static Course javaBasic = new Course("1A", "Java Basic", 3);
    static Course pythonIntermedium = new Course("2B", "Python Intermedium", 5);
    static Course springBootExpert = new Course("3C", "Spring Boot Expert", 2);
    static Course databaseSQL = new Course("4D", "Database SQL", 4);
    static Course webVueJs = new Course("5E", "Web Development Vue.js", 6);
    

    
        
    public static void main(String[] args) {

       

        logger.info("main initialized");
        try {
        studentService.registerStudent(student1);
        studentService.registerStudent(student2);
        studentService.registerStudent(student3);
        studentService.registerStudent(student4);
        courseService.addCourseCreated(javaBasic);
        courseService.addCourseCreated(pythonIntermedium);
        courseService.addCourseCreated(springBootExpert);
        courseService.addCourseCreated(databaseSQL);
        courseService.addCourseCreated(webVueJs);
        registrationService.registerStudent(student1, webVueJs);
        registrationService.registerStudent(student2, webVueJs);
        registrationService.registerStudent(student3, javaBasic);
        registrationService.registerStudent(student4, javaBasic);
        registrationService.registerStudent(student1, databaseSQL);
        } catch (StudentDuplicatedException | CourseDuplicateException | CourseFullException e) {
            System.out.println("Initial setup error: " + e.getMessage());
        }
        int option = 0;
        do {
            
        
        mainMenu();
        option = entry.nextInt();
        entry.nextLine();
        switch (option) {
            case 1 -> manageStudentsMenu();
            case 2 -> manageRegistersMenu();
            case 3 -> manageCoursesMenu();
            default-> mainMenu();
        }
        } while (option!=0);

        entry.close();


    }

    //interface methods
    public static void mainMenu(){

        

        
        var options = """
                == Main Menu ==
                please select one option:
                1. - Manage Students
                2. - Manage Registers
                3. - Manage Courses
                0. - Exit
                """;
                System.out.println(options);
     }

    public static void manageStudentsMenu(){
        int option =0;
        do {
        var options = """
                == Manage Students Menu ==
                please select one option:
                1. - Register Student in System
                2. - List Courses by Student
                0. - Exit
                """;
        System.out.println(options);
        option =entry.nextInt();
        entry.nextLine();
        switch (option) {
                case 1 -> registerStudent();
                case 2 -> listCoursesByStudent();
                case 0 -> {}
                default -> System.out.println("Invalid option, try again.");
        }
        } while (option != 0);
    }

    public static void manageRegistersMenu(){
        int option =0;
        do {
        var options = """
                == Manage Registrations ==
                please select one option:
                1. - List Registrations 
                2. - List Registrations by Student
                3. - Register Student to Course
                0. - Exit
                """;
                System.out.println(options);
        option = entry.nextInt();
        entry.nextLine();
        switch (option) {
            case 1 -> listRegistrations();
            case 2 -> listRegistrationsByStudent();
            case 3 -> registerStudentToCourse();
            case 0 -> {}
            default -> System.out.println("Invalid option, try again.");
        }
        } while (option != 0);
     }
    
     public static void manageCoursesMenu(){
        int option =0;
        do {
        var options ="""
                == Manage Courses Menu ==
                please select one option:
                1. - Register Course
                2. - Search course by Code
                3. - List Available Courses
                0. - Exit
                """;

                System.out.println(options);
        option = entry.nextInt();
        entry.nextLine();
        switch (option) {
            case 1 -> registerCourse();
            case 2 -> searchCourseByCode();
            case 3 -> listAvailableCourses();
            case 0 -> {}
            default -> System.out.println("Invalid option, try again.");
        }
        } while (option != 0);
     }

    public static void registerStudent(){
        try {
        String name, email;
        int id;

        System.out.println("type Student id :");
        id = entry.nextInt();
        entry.nextLine();
        System.out.println("type Student name :");
        name = entry.nextLine();
        System.out.println("type Student email :");
        email = entry.nextLine();
        System.out.println();
        Student newStudent= new Student(name, id, email);
        studentService.registerStudent(newStudent);
        System.out.println("Student registered successfully.");
        } catch (StudentDuplicatedException e) {
            System.out.println("Error: " + e.getMessage());
        }
     }

    public static void listCoursesByStudent(){
        try {
        int id = 0;
        int count=1;
        System.out.println("Type the student code to search: ");
        id =entry.nextInt();
        entry.nextLine();
        for (Registration registration :registrationService.listRegistrationsByStudent(id)){
            System.out.println (count+". - "+registration.getCourse().getName());
            count++;
        }
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }


     }


    public static void listRegistrations(){

        int count =1;
        System.out.println("Registrations in System: ");
        for(Registration registration : registrationService.listRegistrations()){
            System.out.println(count+". - Student name: "+registration.getStudent().getName()+" Course: "+registration.getCourse().getName() + " Date: "+registration.getDate());
            count ++;
        }

    }

    public static void listRegistrationsByStudent (){

        try {
        int count =0;
        int id=0;

        System.out.println(" type the student id to search: ");
        id=entry.nextInt();
        entry.nextLine();

        for(Registration registration : registrationService.listRegistrationsByStudent(id)){
            count ++;
            if (registration.getStudent().getId()==id){
                System.out.println(count+". - Student name: "+registration.getStudent().getName()+" Course: "+registration.getCourse().getName() + " Date: "+registration.getDate());

            }
        }
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void registerStudentToCourse(){

        try {
        int id = 0;
        String code;
        System.out.println("Type The Student Id: ");
        id =entry.nextInt();
        entry.nextLine();
        System.out.println("Type The Course Code");
        code = entry.nextLine();
        Student student = studentService.searchStudentBycode(id);
        Course course = courseService.searchCourseByCode(code);
        registrationService.registerStudent(student,course );
        System.out.println("Student registered to course successfully.");
        logger.info("the student: "+id+" has been registered to "+course.getName()+" succesfully");
        } catch (StudentNotFoundException | NotFoundException | CourseFullException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void registerCourse(){
        
        try {
        String name,code;
        int capacity=0;

        System.out.println("Type The Code Course");
        code = entry.nextLine();
        System.out.println("Type The Name Course");
        name = entry.nextLine();
        System.out.println("Type The Maximum Capacity Course");
        capacity = entry.nextInt();
        entry.nextLine();
        courseService.addCourse(code,name,capacity);
        System.out.println("Course registered successfully.");
        logger.info("Course Created Succesfully:{}{}{} ",name, code, capacity );
        } catch (CourseDuplicateException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void searchCourseByCode(){
        try {
        String code ;
        System.out.println("Type The Course Code to Search: ");
        code = entry.nextLine();
        Course course =courseService.searchCourseByCode(code);
        System.out.println("course has found:\n course Code: "+course.getCode()+" Course Name: "+course.getName());
        } catch (NotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listAvailableCourses(){
        try {
        int count =1;
        System.out.println("Available Courses :");
        for(Course course : courseService.listAvailableCourses()){
            System.out.println(count+". - Course Name :"+course.getName());
            count ++;
        }
        } catch (CourseFullException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}