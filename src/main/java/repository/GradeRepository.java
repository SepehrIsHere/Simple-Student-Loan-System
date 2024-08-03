package repository;

import entity.Course;
import entity.Grade;
import entity.Student;

import java.util.List;

public interface GradeRepository<T extends Grade> {
    void add(T grade);

    void update(T grade);

    void delete(T grade);

    List<T> getAll();

    T getById(Long id);

    List<T> findByStudent(Student student);

    List<T> findByCourse(Course course);
}
