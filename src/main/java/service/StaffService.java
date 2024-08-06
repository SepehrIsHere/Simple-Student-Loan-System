package service;

import entity.Staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface StaffService<T extends Staff> {
    void add(T entity);

    void delete(T entity);

    void deleteById(Long id);

    void update(T entity);

    T findById(Long id);

    List<T> findAll();

    void manageStudents(Scanner input) throws SQLException;

    void manageFaculty(Scanner input) throws SQLException;

    void manageStaff(Scanner input) throws SQLException;

    void manageCourses(Scanner input) throws SQLException;

    String viewPayroll(T staff);

    Staff login(Staff staff);
}
