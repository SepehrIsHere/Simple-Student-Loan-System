package service.impl;

import entity.Course;
import entity.SelectUnit;
import entity.Student;
import repository.StudentRepository;
import service.CourseService;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService<Student> {
    private final StudentRepository studentRepository;
    private final CourseService courseService;

    public StudentServiceImpl(StudentRepository studentRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }

    @Override
    public void add(Student entity) {
        try {
            studentRepository.add(entity);
        } catch (Exception e) {
            System.out.println("An error occured while adding a student" + e.getMessage());
        }
    }

    @Override
    public void update(Student entity) {
        try {
            studentRepository.update(entity);
        } catch (Exception e) {
            System.out.println("An error occured while updating a student" + e.getMessage());
        }
    }

    @Override
    public void delete(Student entity) {
        try {
            studentRepository.delete(entity);
        } catch (Exception e) {
            System.out.println("An error occured while deleting a student" + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("An error occured while deleting a student" + e.getMessage());
        }
    }

    @Override
    public Student findById(Long id) {
        try {
            return studentRepository.findById(id);
        } catch (Exception e) {
            System.out.println("An error occured while finding a student" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            System.out.println("An error occured while finding all students" + e.getMessage());
        }
        return null;
    }

    @Override
    public Student findByLastName(String lastName) {
        try {
            return studentRepository.findByLastName(lastName);
        } catch (Exception e) {
            System.out.println("An error occured while finding a student" + e.getMessage());
        }
        return null;
    }


    @Override
    public List<SelectUnit> getSelectedUnits(Student student) {
        try {
            return studentRepository.getSelectedUnits(student);
        } catch (Exception e) {
            System.out.println("An error occurred while getting selected courses and grades: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> findStudentCourses(Long studentId) {
        try {
            studentRepository.findStudentCourses(studentId);
        } catch (Exception e) {
            System.out.println("An error occurred while getting selected courses: " + e.getMessage());
        }
        return null;
    }
}
