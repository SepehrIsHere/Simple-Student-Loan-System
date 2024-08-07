package repository;

import entity.Course;
import entity.SelectUnit;
import entity.Student;

import java.util.List;

public interface StudentRepository extends BaseEntityRepository<Student> {
    Student findById(Long id);

    List<Student> findAll();

    Student findByLastName(String lastName);
    
    List<SelectUnit> getSelectedUnits(Student student);

    List<Course> findStudentCourses(Long studentId);
}
