package menu;

import entity.Course;
import entity.Faculty;
import entity.SelectUnit;
import entity.Student;
import service.CourseService;
import service.FacultyService;
import service.SelectUnitService;
import service.StudentService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FacultyMenu {
    private final FacultyService<Faculty> facultyService;
    private final CourseService<Course> courseService;
    private final StudentService<Student> studentService;
    private final SelectUnitService<SelectUnit> selectUnitService;

    public FacultyMenu(FacultyService<Faculty> facultyService, CourseService<Course> courseService, StudentService<Student> studentService, SelectUnitService<SelectUnit> selectUnitService) {
        this.facultyService = facultyService;
        this.courseService = courseService;
        this.studentService = studentService;
        this.selectUnitService = selectUnitService;
    }

    public void showStudentMenu() {
        Scanner input = new Scanner(System.in);
        boolean continueRunning = true;
        while (continueRunning) {
            try {
                System.out.println("""
                        Faculty menu!
                        1. Display Faculty information
                        2. Add grade
                        3. Display pay slip
                        4. Exit
                        """);
                int option = input.nextInt();
                input.nextLine();
                switch (option) {
                    case 1 -> displayFacultyInformation(input);
                    case 2 -> addGrade(input);
                    case 3 -> displayPaySlip(input);
                    case 4 -> continueRunning = false;
                    default -> System.out.println("Invalid option. Please select a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    void displayFacultyInformation(Scanner input) {
        try {
            System.out.println("Enter faculty id: ");
            Long facultyId = input.nextLong();
            input.nextLine(); // Consume newline
            Faculty faculty = facultyService.findById(facultyId);
            if (faculty == null) {
                System.out.println("Faculty not found.");
                return;
            }
            System.out.println("Firstname: " + faculty.getFirstName());
            System.out.println("Lastname: " + faculty.getLastName());
            System.out.println("National code: " + faculty.getNationalCode());
            System.out.println("Phone number: " + faculty.getPhoneNumber());
            System.out.println("Faculty Type: " + faculty.getFacultyType().toString());
            System.out.println("Base salary: " + faculty.getBaseSalary());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid faculty id.");
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Failed to display faculty information: " + e.getMessage());
        }
    }

    void addGrade(Scanner input) {
        try {
            System.out.println("Enter Faculty id: ");
            Long facultyId = input.nextLong();
            input.nextLine();
            Faculty faculty = facultyService.findById(facultyId);

            if (faculty == null) {
                System.out.println("Faculty not found.");
                return;
            }

            System.out.println("Enter course id: ");
            Long courseId = input.nextLong();
            input.nextLine(); // Consume newline
            Course course = courseService.findById(courseId);

            if (course == null) {
                System.out.println("Course not found.");
                return;
            }

            if (doesFacultyTeachTheCourse(courseId, facultyId)) {
                System.out.println("Enter student's last name: ");
                String lastName = input.nextLine();
                Student student = studentService.findByLastName(lastName);

                if (student == null) {
                    System.out.println("Student not found.");
                    return;
                }

                SelectUnit selectUnit = selectUnitService.findByCourseAndStudent(course.getId(), student.getId());

                if (selectUnit == null) {
                    System.out.println("Student is not enrolled in the course.");
                    return;
                }

                System.out.println("Enter grade: ");
                double grade = input.nextDouble();
                selectUnit.setGrade(grade);
                selectUnitService.update(selectUnit);
                System.out.println("Grade added successfully!");
            } else {
                System.out.println("The student is not in the course or Faculty does not teach the course");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Failed to add grade: " + e.getMessage());
        }
    }

    void displayPaySlip(Scanner input) {
        try {
            System.out.println("Enter faculty id: ");
            Long facultyId = input.nextLong();
            input.nextLine();
            Faculty faculty = facultyService.findById(facultyId);

            if (faculty == null) {
                System.out.println("Faculty not found.");
                return;
            }

            System.out.println("Firstname: " + faculty.getFirstName());
            System.out.println("Lastname: " + faculty.getLastName());
            System.out.println("National code: " + faculty.getNationalCode());
            System.out.println("Phone number: " + faculty.getPhoneNumber());
            System.out.println("Monthly Salary: " + calculateMonthlySalary(faculty));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid faculty id.");
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Failed to display pay slip: " + e.getMessage());
        }
    }

    double calculateMonthlySalary(Faculty faculty) {
        List<Course> taughtUnits = courseService.findByFacultyId(faculty.getId());
        int countOfTaughtUnits = 0;
        for (Course course : taughtUnits) {
            countOfTaughtUnits += course.getLesson().getUnit();
        }
        if (faculty.getFacultyType().toString().equalsIgnoreCase("tuition")) {
            return (faculty.getBaseSalary() + countOfTaughtUnits) * 1000000;
        } else if (faculty.getFacultyType().toString().equalsIgnoreCase("associate")) {
            return countOfTaughtUnits * 1000000;
        }
        return 0;
    }

    private boolean doesFacultyTeachTheCourse(Long courseId, Long facultyId) {
        try {
            Faculty faculty = facultyService.findById(facultyId);
            Course course = courseService.findById(courseId);
            return course.getFaculty().getId().equals(faculty.getId());
        } catch (Exception e) {
            System.out.println("Error checking if faculty teaches the course: " + e.getMessage());
            return false;
        }
    }
}
