package service.impl;

import entity.Faculty;
import entity.Person;
import entity.Staff;
import entity.Student;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import repository.UserRepository;
import service.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Student loginStudent(Student student) {
        try {
            return userRepository.loginStudent(student.getUsername(), student.getPassword());
        } catch (NoResultException e) {
            System.out.println("Student not found: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Faculty loginFaculty(Faculty faculty) {
        try {
            return userRepository.loginFaculty(faculty.getUsername(), faculty.getPassword());
        } catch (NoResultException e) {
            System.out.println("Faculty not found: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Staff loginStaff(Staff staff) {
        try {

            return userRepository.loginStaff(staff.getUsername(), staff.getPassword());
        } catch (NoResultException e) {
            System.out.println("Staff not found: " + e.getMessage());
        }
        return null;
    }
}
