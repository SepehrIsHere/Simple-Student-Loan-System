package repository;

import entity.Faculty;
import entity.Person;
import entity.Staff;
import entity.Student;

public interface UserRepository {
    Student loginStudent(String username, String password);

    Faculty loginFaculty(String username, String password);

    Staff loginStaff(String username,String password);
}
