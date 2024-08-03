package repository;

import entity.Student;

import java.util.List;

public interface StudentRepository <T extends Student> {
    void save(T entity);

    void delete(T entity);

    void update(T entity);

    T findById(Long id);

    List<T> findAll();

    T findByLastName(String lastName);
}
