package repository;

import entity.Faculty;

import java.util.List;

public interface FacultyRepository<T extends Faculty> {
    void save(T entity);

    void delete(T entity);

    void update(T entity);

    T findById(Long id);

    List<T> findAll();

}
