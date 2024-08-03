package repository;

import entity.Student;

import java.util.List;

public interface StudentRepository extends BaseEntityRepository<Student> {
    Student findByLastName(String lastName);
}
