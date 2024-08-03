package repository;

import entity.Course;
import entity.Faculty;

import java.util.List;

public interface CourseRepository extends BaseEntityRepository<Course> {
    List<Course> findByCourseName(String courseName);

    List<Course> findByFacultyId(Long facultyId);
}
