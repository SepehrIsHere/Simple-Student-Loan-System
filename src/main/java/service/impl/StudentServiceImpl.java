package service.impl;

import entity.Student;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl<T extends Student> implements StudentService<Student> {
    private final StudentRepository<Student> repository;

    public StudentServiceImpl(StudentRepository<Student> repository) {
        this.repository = repository;
    }

    @Override
    public void save(Student entity) {
        try {
            repository.save(entity);
        } catch (Exception e) {
            System.out.println("Error while saving student" + e.getMessage());
        }
    }

    @Override
    public void delete(Student entity) {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            System.out.println("Error while deleting student" + e.getMessage());
        }
    }

    @Override
    public void update(Student entity) {
        try {
            repository.update(entity);
        } catch (Exception e) {
            System.out.println("Error while updating student" + e.getMessage());
        }
    }

    @Override
    public Student findById(Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.out.println("Error while finding student" + e.getMessage());
        }
    }

    @Override
    public List<Student> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            System.out.println("Error while finding student" + e.getMessage());
        }
    }

    @Override
    public Student findByLastName(String lastName) {
        try {
            return repository.findByLastName(lastName);
        } catch (Exception e) {
            System.out.println("Error while finding student" + e.getMessage());
        }
        return null;
    }
}
