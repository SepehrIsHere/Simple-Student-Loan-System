package repository;

import entity.Course;
import entity.Faculty;

import java.util.List;

public interface FacultyRepository extends BaseEntityRepository<Faculty> {
    Faculty findById(Long id);

    List<Faculty> findAll();
}
