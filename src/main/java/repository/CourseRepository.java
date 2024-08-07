package repository;

import entity.Course;
import entity.Faculty;
import entity.Student;

import java.util.List;

public interface CourseRepository extends BaseEntityRepository<Course> {
    Course findById(Long id);

    List<Course> findAll();

    List<Course> findByCourseName(String courseName);

    List<Course> findByCourseId(Integer courseId);

    List<Course> findByFacultyId(Long facultyId);

    List<Student> findStudentsFromCourse(Long courseId);

    List<Course> findStudentsEnrolledCourses(Long studentId);

}
