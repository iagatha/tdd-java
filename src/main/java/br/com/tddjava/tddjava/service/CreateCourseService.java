package br.com.tddjava.tddjava.service;

import br.com.tddjava.tddjava.models.Entities.course.Course;
import br.com.tddjava.tddjava.repositories.ICourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseService {

    private ICourseRepository repository;
    public  CreateCourseService(ICourseRepository repository){
       this.repository = repository;
    }
    public Course execute(Course course){
        // Validar se o curso existe
        Course existedCourse = repository.findByName(course.getName());

        // Se sim, retorna ele

        if (existedCourse != null){
            throw new Error("Curso já existe!");
        }

        // Se não, Salvar e retornar um novo curso
        return repository.save(course);

    }
}
