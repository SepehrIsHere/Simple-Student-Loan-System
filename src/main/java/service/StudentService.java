package service;

import entity.Student;

import java.util.List;

public interface StudentService<T extends Student> {
    void add(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(Long id);

    T findById(Class<Student> entity, Long id);

    List<T> findAll(Class<Student> entity);

    T findByLastName(String lastName);
}
