package service;

import entity.Faculty;
import entity.Person;
import entity.Staff;
import entity.Student;

public interface UserService {
    Student loginStudent(Student student);

    Faculty loginFaculty(Faculty faculty);

    Staff loginStaff(Staff staff);
}
