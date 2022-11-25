package br.com.tddjava.tddjava.service;

import br.com.tddjava.tddjava.models.Entities.course.Course;
import br.com.tddjava.tddjava.repositories.CourseInMemoryRepository;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions. *;

public class CreateCourseServiceTeste {
    @Test
    public void should_be_able_to_create_a_new_course(){
        //Criar um novo curso
        //criar tabela de curso(Entidade)
        // ID, description, name, workload
        Course course = new Course();
        course.setDescription("Curso_Description_Test");
        course.setName("Curso_Name");
        course.setWorkload(100);

        //Criar um Repository de curso
        CourseInMemoryRepository repository = new CourseInMemoryRepository();

        //Criar um novo service
        CreateCourseService createCourseService = new CreateCourseService(repository);
        Course createCourse = createCourseService.execute(course);


        assertNotNull(createCourse.getId());


    }

    @Test(expected = Error.class)
    public void should_not_be_able_to_create_a_new_course_if_exists(){
        Course course = new Course();
        course.setDescription("Not_Create_Course");
        course.setName("Not_Create_Course");
        course.setWorkload(100);

        CourseInMemoryRepository repository = new CourseInMemoryRepository();

        CreateCourseService createCourseService = new CreateCourseService(repository);
        createCourseService.execute(course);
        createCourseService.execute(course);

    }
}
