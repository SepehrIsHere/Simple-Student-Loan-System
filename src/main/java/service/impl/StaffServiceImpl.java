package service.impl;

import entity.Course;
import entity.Faculty;
import entity.Staff;
import entity.Student;
import repository.CourseRepository;
import repository.FacultyRepository;
import repository.StaffRepository;
import repository.StudentRepository;
import service.CourseService;
import service.FacultyService;
import service.StaffService;
import service.StudentService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StaffServiceImpl implements StaffService<Staff> {
    private final StaffRepository staffRepository;
    private final StudentService<Student> studentService;
    private final FacultyService<Faculty> facultyService;
    private final CourseService<Course> courseService;

    public StaffServiceImpl(StaffRepository staffRepository, StudentService<Student> studentService, FacultyService<Faculty> facultyService, CourseService<Course> courseService) {
        this.staffRepository = staffRepository;
        this.studentService = studentService;
        this.facultyService = facultyService;
        this.courseService = courseService;
    }

    @Override
    public void add(Staff entity) {
        try {
            staffRepository.add(entity);
        } catch (Exception e) {
            System.out.println("Expcetion while adding staff" + e.getMessage());
        }
    }

//    @Override
//    public Staff findByUsername(String username) {
//        return staffRepository.findByUsername(username);
//    }

    @Override
    public void delete(Staff entity) {
        try {
            staffRepository.delete(entity);
        } catch (Exception e) {
            System.out.println("Expcetion while deleting staff" + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            staffRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Expcetion while deleting staff" + e.getMessage());
        }
    }

    @Override
    public void update(Staff entity) {
        try {
            staffRepository.update(entity);
        } catch (Exception e) {
            System.out.println("Expcetion while updating staff" + e.getMessage());
        }
    }

    @Override
    public Staff findById(Long id) {
        try {
            return staffRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Expcetion while finding staff" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Staff> findAll() {
        try {
            return staffRepository.findAll();
        } catch (Exception e) {
            System.out.println("Expcetion while finding staff" + e.getMessage());
        }
        return null;
    }

    @Override
    public void manageStudents(Scanner input) throws SQLException {
        System.out.println("1. Add Student\n2. Update Student\n3. Delete Student\n4. View Students");
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                Student student = new Student();
                // Populate student fields from input
                studentService.add(student);
                break;
            case 2:
                System.out.println("Enter student ID to update:");
                Long studentId = input.nextLong();
                input.nextLine(); // Consume newline
                Student existingStudent = studentService.findById(studentId);
                // Update student fields from input
                studentService.update(existingStudent);
                break;
            case 3:
                System.out.println("Enter student ID to delete:");
                Long studentIdToDelete = input.nextLong();
                input.nextLine(); // Consume newline
                studentService.deleteById(studentIdToDelete);
                break;
            case 4:
                List<Student> students = studentService.findAll();
                students.forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    @Override
    public void manageFaculty(Scanner input) throws SQLException {
        System.out.println("1. Add Faculty\n2. Update Faculty\n3. Delete Faculty\n4. View Faculty");
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                Faculty faculty = new Faculty();
                // Populate faculty fields from input
                facultyService.save(faculty);
                break;
            case 2:
                System.out.println("Enter faculty ID to update:");
                Long facultyId = input.nextLong();
                input.nextLine(); // Consume newline
                Faculty existingFaculty = facultyService.findById(facultyId);
                // Update faculty fields from input
                facultyService.update(existingFaculty);
                break;
            case 3:
                System.out.println("Enter faculty ID to delete:");
                Long facultyIdToDelete = input.nextLong();
                input.nextLine(); // Consume newline
                facultyService.delete(facultyService.findById(facultyIdToDelete));
                break;
            case 4:
                List<Faculty> faculties = facultyService.findAll();
                faculties.forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    @Override
    public void manageStaff(Scanner input) throws SQLException {
        System.out.println("1. Add Staff\n2. Update Staff\n3. Delete Staff\n4. View Staff");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                Staff staff = new Staff();
                staffRepository.add(staff);
                break;
            case 2:
                System.out.println("Enter staff ID to update:");
                Long staffId = input.nextLong();
                input.nextLine();
                Staff existingStaff = staffRepository.findById(staffId);
                staffRepository.update(existingStaff);
                break;
            case 3:
                System.out.println("Enter staff ID to delete:");
                Long staffIdToDelete = input.nextLong();
                input.nextLine();
                staffRepository.deleteById(staffIdToDelete);
                break;
            case 4:
                List<Staff> staffs = staffRepository.findAll();
                staffs.forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    @Override
    public void manageCourses(Scanner input) throws SQLException {
        System.out.println("1. Add Course\n2. Update Course\n3. Delete Course\n4. View Courses");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                Course course = new Course();

                courseService.add(course);
                break;
            case 2:
                System.out.println("Enter course ID to update:");
                Long courseId = input.nextLong();
                input.nextLine();
                Course existingCourse = courseService.findById(courseId);
                courseService.update(existingCourse);
                break;
            case 3:
                System.out.println("Enter course ID to delete:");
                Long courseIdToDelete = input.nextLong();
                input.nextLine();
                courseService.delete(courseService.findById(courseIdToDelete));
                break;
            case 4:
                List<Course> courses = courseService.findAll();
                courses.forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    @Override
    public String viewPayroll(Staff staff) {
        return "Payroll for " + staff.getFirstName() +  staff.getLastName() + ": ";
    }

    @Override
    public Staff login(Staff staff) {
        return staffRepository.login(staff);
    }
}
