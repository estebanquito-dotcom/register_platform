import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.plataforma.exception.CourseDuplicateException;
import com.plataforma.model.Course;
import com.plataforma.service.CourseService;

public class CourseServiceTest {

    private CourseService courseService;

    @BeforeEach
    void setUp(){
        courseService = new CourseService();
    }

    @Test
    void createCourseTest(){
        courseService.addCourse("1J","java basic",5 );
        courseService.addCourse("1P","python intermedium",5);

        assertEquals(2, courseService.listCourses().size());
    }

    @Test
    void addCreatedCourseTest(){
        Course course1 = new Course("1J", "java basic", 5);
        Course course2 = new Course("1P", "python intermedium", 5);
        Course course3 = new Course("1S", "spring security", 5);


        courseService.addCourseCreated(course1);
        courseService.addCourseCreated(course2);
        courseService.addCourseCreated(course3);

        assertEquals(3, courseService.listCourses().size());


    }

    @Test
    void courseDuplicateTest(){

        Course course1 = new Course("1J", "java basic", 5);
        Course course2 = new Course("1J", "java basic", 5);

        courseService.addCourseCreated(course1);

        CourseDuplicateException exception = assertThrows(CourseDuplicateException.class, ()->{
            courseService.addCourseCreated(course2);
        });

    }


}
