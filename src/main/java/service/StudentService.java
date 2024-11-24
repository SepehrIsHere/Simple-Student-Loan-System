package service;

import entity.Course;
import entity.SelectUnit;
import entity.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface StudentService<T extends Student> {
    void add(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(Long id);

    T findById(Long id);

    List<T> findAll();

    T findByLastName(String lastName);

    List<SelectUnit> getSelectedUnits(Student student);

    List<Course> findStudentCourses(Long studentId);

}
