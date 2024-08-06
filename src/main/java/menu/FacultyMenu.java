package menu;

import entity.Course;
import entity.Faculty;
import entity.SelectUnit;
import entity.Student;
import service.CourseService;
import service.FacultyService;
import service.StudentService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FacultyMenu {
    private final FacultyService<Faculty> facultyService;
    private final CourseService<Course> courseService;
    private final StudentService<Student> studentService;

    public FacultyMenu(FacultyService<Faculty> facultyService, CourseService<Course> courseService, StudentService<Student> studentService) {
        this.facultyService = facultyService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public void showStudentMenu() {
        Scanner input = new Scanner(System.in);
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("""
                    Student menu!
                    1.Display Faculty information
                    2.Add grade
                    3.Display pay role
                    4.Exit
                    """);
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1 -> displayFacultyInformation(input);
                case 2 -> addGrade(input);
                case 3 -> displayPaySlip(input);
                case 4 -> continueRunning = false;
                default -> System.out.println("Wrong option");
            }
        }
    }

    private void displayFacultyInformation(Scanner input) {
        System.out.println("Enter faculty id : ");
        Long facultyId = input.nextLong();
        Faculty faculty = facultyService.findById(facultyId);
        System.out.println("Firstname : " + faculty.getFirstName());
        System.out.println("Lastname : " + faculty.getLastName());
        System.out.println("National code : " + faculty.getNationalCode());
        System.out.println("Phone number : " + faculty.getPhoneNumber());
        System.out.println("Faculty Type" + faculty.getFacultyType().toString());
        System.out.println("Base salay : " + faculty.getBaseSalary());
    }

    private void addGrade(Scanner input) {
        System.out.println("Enter faculty's id : ");
        Long facultyId = input.nextLong();
        Faculty faculty = new Faculty();
        faculty.setId(facultyId);

        System.out.println("Enter student's last name : ");
        String lastName = input.nextLine();
        Student student = studentService.findByLastName(lastName);
        if (isInFacultyCourse(student, faculty)) {
            System.out.println("Enter course id : ");
            Long courseId = input.nextLong();
            Course course = courseService.findById(courseId);
            System.out.println("Enter grade : ");
            double grade = input.nextDouble();
            if (grade < 0 && grade > 20) {
                System.out.println("Invalid grade");
            } else {
                SelectUnit selectUnit = new SelectUnit();
                selectUnit.setCourse(course);
                selectUnit.setStudent(student);
                selectUnit.setGrade(grade);
            }
        }
    }

    private void displayPaySlip(Scanner input) {
        System.out.println("Enter faculty id : ");
        Long facultyId = input.nextLong();
        Faculty faculty = facultyService.findById(facultyId);
        System.out.println("Firstname : " + faculty.getFirstName());
        System.out.println("Lastname : " + faculty.getLastName());
        System.out.println("National code : " + faculty.getNationalCode());
        System.out.println("Month Salary : " + calculateMonthlySalary(faculty));

    }

    private double calculateMonthlySalary(Faculty faculty) {
        List<Course> taughtUnits = courseService.findByFacultyId(faculty.getId());
        int countOfTaughtUnits = 0;
        for (Course course : taughtUnits) {
            countOfTaughtUnits += course.getLesson().getUnit();
        }
        if (faculty.getFacultyType().toString().equals("tuition")) {
            return (faculty.getBaseSalary() + countOfTaughtUnits) * 1000000;
        } else if (faculty.getFacultyType().toString().equals("associate")) {
            return countOfTaughtUnits * 1000000;
        }
        return 0;
    }

    private boolean isInFacultyCourse(Student student, Faculty faculty) {
        List<Course> facultyCourses = courseService.findByFacultyId(faculty.getId());
        for (Course course : facultyCourses) {
            List<Student> courseStudents = course.getStudents();
            for (Student student1 : courseStudents) {
                if (Objects.equals(student1.getId(), student.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
