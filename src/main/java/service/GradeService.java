package service;

import entity.Course;
import entity.Grade;
import entity.Student;

import java.util.List;

public interface GradeService <T extends Grade> {
    void add(T entity);

    void delete(T entity);

    void update(T entity);

    T findById(Class<Grade> entity,Long id);

    List<T> findAll(Class<Grade> entity);

    List<T> findByStudentId(Student student);

    List<T> findByCourseId(Course course);
}
