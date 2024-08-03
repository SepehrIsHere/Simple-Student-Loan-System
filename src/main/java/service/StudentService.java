package service;

import entity.Student;

import java.util.List;

public interface StudentService<T extends Student> {
    void save(T entity);

    void delete(T entity);

    void update(T entity);

    T findById(Long id);

    List<T> findAll();

    T findByLastName(String lastName);
}
