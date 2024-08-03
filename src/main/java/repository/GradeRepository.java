package repository;

import entity.Course;
import entity.Grade;
import entity.Student;

import java.util.List;

public interface GradeRepository extends BaseEntityRepository<Grade>{

    List<Grade> findByStudent(Long studentId);

    List<Grade> findByCourse(Long courseId);
}
