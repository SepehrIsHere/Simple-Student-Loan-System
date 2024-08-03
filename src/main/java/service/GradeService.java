package service;

import entity.Course;
import entity.Grade;
import entity.Student;

import java.util.List;

public interface GradeService <T extends Grade> {
    void save(T entity);

    void delete(T entity);

    void update(T entity);

    T findById(Long id);

    List<T> findAll();

    List<T> findByStudentId(Student student);

    List<T> findByCourseId(Course course);
}
