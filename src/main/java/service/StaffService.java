package service;

import entity.Staff;

import java.util.List;

public interface StaffService <T extends Staff> {
    void add(T entity);

    void delete(T entity);

    void deleteById(Long id);

    void update(T entity);

    T findById(Class<Staff> entity ,Long id);

    List<T> findAll(Class<Staff> entity);

}
