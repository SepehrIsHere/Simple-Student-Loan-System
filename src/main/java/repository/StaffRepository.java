package repository;

import entity.Course;
import entity.Staff;

import java.util.List;

public interface StaffRepository extends BaseEntityRepository<Staff> {
    Staff findById(Long id);

    List<Staff> findAll();

    Staff findByUsername(String username);

    Staff login(Staff staff);
}
