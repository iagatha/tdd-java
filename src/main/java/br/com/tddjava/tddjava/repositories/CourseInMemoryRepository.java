package br.com.tddjava.tddjava.repositories;

import br.com.tddjava.tddjava.models.Entities.course.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CourseInMemoryRepository implements ICourseRepository {

    private List<Course> course;

    public CourseInMemoryRepository(){
        this.course = new ArrayList<>();
    }
    @Override
    public Course findByName(String name) {
        Optional <Course> optionalCourse = this.course.stream().filter(course -> course.getName().equals(name))
                .findFirst();
        return optionalCourse.orElse(null);
    }

    @Override
    public Course save(Course course) {
       this.course.add(course);
       course.setId(UUID.randomUUID());
       return course;
    }
}
