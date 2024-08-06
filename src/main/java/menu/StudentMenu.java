package menu;

import entity.Course;
import entity.SelectUnit;
import entity.Student;
import service.CourseService;
import service.SelectUnitService;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    private final StudentService<Student> studentService;
    private final CourseService<Course> courseService;
    private final SelectUnitService<SelectUnit> selectUnitService;

    public StudentMenu(StudentService<Student> studentService, CourseService<Course> courseService, SelectUnitService<SelectUnit> selectUnitService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.selectUnitService = selectUnitService;
    }

    public void showStudentMenu() {
        Scanner input = new Scanner(System.in);
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("""
                    Student menu!
                    1.display student information
                    2.display all courses
                    3.select Unit
                    4.Exit
                    """);
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1 -> displayStudentInformation(input);
                case 2 -> displayEnrolledCourses(input);
                case 3 -> selectUnits(input);
                case 4 -> continueRunning = false;
                default -> System.out.println("Wrong option");
            }
        }
    }

    private void displayStudentInformation(Scanner input) {
        System.out.println("Enter Student's id : ");
        Long id = input.nextLong();
        Student student = studentService.findById(id);
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("National code : " + student.getNationalCode());
        System.out.println("Phone number : " + student.getPhoneNumber());
        System.out.println("Username : " + student.getUsername());
        System.out.println("Password : " + student.getPassword());
    }

    private void displayEnrolledCourses(Scanner input) {
        System.out.println("Enter student id : ");
        Long id = input.nextLong();
        Student student = studentService.findById(id);
        List<SelectUnit> selectedUnits = selectUnitService.findByStudentId(student);
        if (selectedUnits.isEmpty()) {
            System.out.println("Student has not enrolled any of courses");
        } else {
            for (SelectUnit selectUnit : selectedUnits) {
                System.out.println("Course name : " + selectUnit.getCourse());
                System.out.println("Lesson : " + selectUnit.getCourse().getLesson().getTitle());
                System.out.println("Unit count : " + selectUnit.getCourse().getLesson().getUnit());
                System.out.println("Faculty info" + selectUnit.getCourse().getFaculty().getFirstName() + selectUnit.getCourse().getFaculty().getLastName());
                System.out.println("Grade : "  + selectUnit.getGrade());
            }
        }
    }

    private void selectUnits(Scanner input) {
        System.out.println("Enter student id : ");
        Long studentId = input.nextLong();
        Student student = studentService.findById(studentId);
        List<SelectUnit> selectUnits = selectUnitService.findByStudentId(student);
        int currentUnits = 0;
        for (SelectUnit selectUnit : selectUnits) {
            currentUnits += selectUnit.getCourse().getLesson().getUnit();
        }
        int maxUnits = (student.getGpa() > 18) ? 24 : 20;


        if (currentUnits >= maxUnits) {
            System.out.println("You have reached the maximum allowed units.");
            return;
        }

        System.out.println("Enter Course id : ");
        Long courseId = input.nextLong();
        Course course = courseService.findById(courseId);

        SelectUnit selectUnit = new SelectUnit();
        selectUnit.setCourse(course);
        selectUnit.setStudent(student);

        if (hasPassedCourse(student, selectUnit)) {
            System.out.println("You have already passed this course.");
            return;
        }

        if (hasSelectedCourse(student, selectUnit)) {
            System.out.println("You have already selected this course for this term.");
            return;
        }

        selectUnitService.add(selectUnit);
        System.out.println("Selected Unit Successfully");
    }

    private boolean hasSelectedCourse(Student student , SelectUnit selectUnit){
        List<SelectUnit> selectUnits = selectUnitService.findByStudentId(student);
        for (SelectUnit selectUnit1 : selectUnits) {
            if(selectUnit.getCourse().getCourseId().equals(selectUnit1.getCourse().getCourseId())){
                return true;
            }
        }
        return false;
    }

    private boolean hasPassedCourse(Student student, SelectUnit selectUnit) {
        return selectUnit.getStudent().getId().equals(student.getId()) && selectUnit.getGrade() != 0 && selectUnit.getGrade() >= 10;
    }
}
