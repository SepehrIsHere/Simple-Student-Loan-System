package service;

import entity.Faculty;

import java.util.List;

public interface FacultyService <Faculty> {
    void save(Faculty entity);

    void delete(Faculty entity);

    void update(Faculty entity);

    Faculty findById(Class<Faculty> entity,Long id);

    List<Faculty> findAll(Class<Faculty> entity);

}
