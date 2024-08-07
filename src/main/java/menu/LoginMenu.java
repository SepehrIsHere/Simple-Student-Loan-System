package menu;

import entity.Faculty;
import entity.Person;
import entity.Staff;
import entity.Student;
import lombok.Getter;
import service.UserService;

import java.util.Scanner;

public class LoginMenu {
    @Getter
    private Person token = null;
    private final UserService userService;

    public LoginMenu(UserService userService) {
        this.userService = userService;
    }

    public void showMenu() {
        Scanner input = new Scanner(System.in);
        boolean continueRunning = true;
        while (continueRunning) {
            try {
                System.out.println("""
                        1. Staff Login
                        2. Faculty Login
                        3. Student Login
                        4. Exit
                        """);
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1 -> continueRunning = !staffLogin(input);
                    case 2 -> continueRunning = !facultyLogin(input);
                    case 3 -> continueRunning = !studentLogin(input);
                    case 4 -> {
                        token = null;
                        continueRunning = false;
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace(); // for debugging purposes
                input.nextLine();
            }
        }
    }

    private boolean staffLogin(Scanner input) {
        try {
            System.out.println("Enter username: ");
            String username = input.nextLine();
            System.out.println("Enter password: ");
            String password = input.nextLine();
            Staff staff = new Staff();
            staff.setUsername(username);
            staff.setPassword(password);
            token = userService.loginStaff(staff);
            if (token == null || token.getId() == null) {
                System.out.println("Invalid username or password");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred during staff login: " + e.getMessage());
            e.printStackTrace(); //  for debugging purposes
            return false;
        }
    }

    private boolean facultyLogin(Scanner input) {
        try {
            System.out.println("Enter username: ");
            String username = input.nextLine();
            System.out.println("Enter password: ");
            String password = input.nextLine();
            Faculty faculty = new Faculty();
            faculty.setUsername(username);
            faculty.setPassword(password);
            token = userService.loginFaculty(faculty);
            if (token == null || token.getId() == null) {
                System.out.println("Invalid username or password");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred during faculty login: " + e.getMessage());
            e.printStackTrace(); //  for debugging purposes
            return false;
        }
    }

    private boolean studentLogin(Scanner input) {
        try {
            System.out.println("Enter username: ");
            String username = input.nextLine();
            System.out.println("Enter password: ");
            String password = input.nextLine();
            Student student = new Student();
            student.setUsername(username);
            student.setPassword(password);
            token = userService.loginStudent(student);
            if (token == null || token.getId() == null) {
                System.out.println("Invalid username or password");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred during student login: " + e.getMessage());
            e.printStackTrace(); // for debugging purposes
            return false;
        }
    }
}
