package service;

import entity.Course;

import java.util.List;

public interface CourseService<Course> {
    void add(Course course);

    void update(Course course);

    void delete(Course course);

    List<Course> findAll();

    Course findById(Long id);

    List<Course> findByCourseName(String courseName);

    List<Course> findByFacultyId(Long facultyId);
}
