import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.plataforma.exception.CourseFullException;
import com.plataforma.model.Course;
import com.plataforma.model.Student;
import com.plataforma.service.RegistrationService;



public class RegistrationServiceTest {

    private RegistrationService registrationService;

    @BeforeEach
    void setUp(){
        registrationService = new RegistrationService();
    }

    @Test
    void registerStudentSuccesfullyTest (){
        
        Course course1 = new Course("1J", "java basic", 1);
        Course course2 = new Course("1P", "python intermedium", 1);
        Course course3 = new Course("1S", "spring security", 2);

        Student student = new Student("paquito", 1, "paquito@gmail.com ");


        registrationService.registerStudent(student, course2);
        registrationService.registerStudent(student, course3);
        registrationService.registerStudent(student, course1);

        assertEquals(3, registrationService.listRegistrations().size());

    }

    @Test
    void registrationCourseFullTest (){

        Course course1 = new Course("1J", "java basic", 1);
        Student student1 = new Student("paquito", 1, "paquito@gmail.com ");
        Student student2 = new Student("juanito", 3, "juanito@gmail.com ");

        registrationService.registerStudent(student1, course1);

        CourseFullException exception = assertThrows(CourseFullException.class, () -> {
            registrationService.registerStudent(student2, course1);
        });

    }


    @Test
    void listRegistrationsByStudentTest(){

        Course course1 = new Course("1J", "java basic", 1);

        Course course3 = new Course("1S", "spring security", 2);

        Student student1 = new Student("paquito", 1, "paquito@gmail.com ");
        Student student2 = new Student("juanito", 2, "juanito@gmail.com ");

        registrationService.registerStudent(student1, course3);
        registrationService.registerStudent(student1, course1);
        registrationService.registerStudent(student2, course3);
        assertEquals(2, registrationService.listRegistrationsByStudent(student1.getId()).size());

    }




}
