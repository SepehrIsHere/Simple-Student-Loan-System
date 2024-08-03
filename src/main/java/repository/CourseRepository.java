package repository;

import entity.Course;
import entity.Faculty;

import java.util.List;

public interface CourseRepository<T extends Course> {
    void save(T course);

    void delete(T course);

    void update(T course);

    List<T> findAll();

    T findById(Long id);

    T findByCourseName(String courseName);

    T findByFacultyId(Faculty faculty);
}
