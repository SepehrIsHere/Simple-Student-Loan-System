package service.impl;

import entity.Course;
import repository.CourseRepository;
import service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService<Course> {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void add(Course course) {
        try {
            courseRepository.add(course);
        } catch (Exception e) {
            System.out.println("Exception while adding course" + e.getMessage());
        }
    }

    @Override
    public void update(Course course) {
        try {
            courseRepository.update(course);
        } catch (Exception e) {
            System.out.println("Exception while updating course" + e.getMessage());
        }
    }

    @Override
    public void delete(Course course) {
        try {
            courseRepository.delete(course);
        } catch (Exception e) {
            System.out.println("Exception while deleting course" + e.getMessage());
        }
    }

    @Override
    public List<Course> findAll() {
        try {
            return courseRepository.findAll();
        } catch (Exception e) {
            System.out.println("Exception while finding course" + e.getMessage());
        }
        return null;
    }

    @Override
    public Course findById(Long id) {
        try {
            return courseRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Exception while finding course" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> findByCourseName(String courseName) {
        try {
            return courseRepository.findByCourseName(courseName);
        } catch (Exception e) {
            System.out.println("Exception while finding course" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> findByFacultyId(Long facultyId) {
        try {
            return courseRepository.findByFacultyId(facultyId);
        } catch (Exception e) {
            System.out.println("Exception while finding course" + e.getMessage());
        }
        return null;
    }
}
