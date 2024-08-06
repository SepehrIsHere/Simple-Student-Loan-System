package service;

import entity.Course;
import entity.SelectUnit;
import entity.Student;

import java.util.List;

public interface SelectUnitService<T extends SelectUnit> {
    void add(T entity);

    void delete(T entity);

    void update(T entity);

    T findById(Long id);

    List<T> findAll();

    List<T> findByStudentId(Student student);

}
