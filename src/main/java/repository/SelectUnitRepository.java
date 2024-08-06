package repository;

import entity.SelectUnit;
import entity.Student;

import java.util.List;

public interface SelectUnitRepository extends BaseEntityRepository<SelectUnit> {
    SelectUnit findById(Long id);

    List<SelectUnit> findAll();

    List<SelectUnit> findByStudent(Long studentId);

    List<SelectUnit> findByCourse(Long courseId);

}
