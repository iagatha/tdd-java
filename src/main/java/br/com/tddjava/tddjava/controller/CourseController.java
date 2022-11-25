package br.com.tddjava.tddjava.controller;

import br.com.tddjava.tddjava.models.Entities.course.Course;
import br.com.tddjava.tddjava.repositories.CourseRepository;
import br.com.tddjava.tddjava.service.CreateCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository repository;

    @PostMapping("/")
    public Course createCourse(@RequestBody Course course){
        CreateCourseService createCourseService = new CreateCourseService(repository);
        return createCourseService.execute(course);
    }
}
