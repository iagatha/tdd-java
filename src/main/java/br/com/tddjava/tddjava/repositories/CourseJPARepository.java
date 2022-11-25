package br.com.tddjava.tddjava.repositories;

import br.com.tddjava.tddjava.models.Entities.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseJPARepository extends JpaRepository<Course, UUID> {
   public Course findByName(String name);
}
