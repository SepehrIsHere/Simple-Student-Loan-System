package service;

import entity.Staff;

import java.util.List;

public interface StaffService <T extends Staff> {
    void save(T entity);

    void delete(T entity);

    void update(T entity);

    T findById(Long id);

    List<T> findAll();

}
