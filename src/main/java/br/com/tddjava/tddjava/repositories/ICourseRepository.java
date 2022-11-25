package br.com.tddjava.tddjava.repositories;

import br.com.tddjava.tddjava.models.Entities.course.Course;

public interface ICourseRepository {

    public Course findByName(String name);
    public Course save(Course course);
}
