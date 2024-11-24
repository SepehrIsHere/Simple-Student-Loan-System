package menu;

import entity.Faculty;
import entity.Person;
import entity.Staff;
import entity.Student;
import enumeration.FacultyType;
import service.FacultyService;
import service.StaffService;
import service.StudentService;
import java.util.Scanner;

public class StaffMenu {
    private final StudentService<Student> studentService;
    private final FacultyService<Faculty> facultyService;
    private final StaffService<Staff> staffService;

    public StaffMenu(StudentService<Student> studentService, FacultyService<Faculty> facultyService, StaffService<Staff> staffService) {
        this.studentService = studentService;
        this.facultyService = facultyService;
        this.staffService = staffService;
    }

    public void showStaffMenu() {
        Scanner input = new Scanner(System.in);
        boolean continueRunning = true;
        while (continueRunning) {
            try {
                System.out.println("""
                        Staff Menu!
                        1. Add Student
                        2. Remove Student
                        3. Edit Student
                        4. Add Faculty
                        5. Remove Faculty
                        6. Edit Faculty
                        7. Add Staff
                        8. Remove Staff
                        9. Edit Staff
                        10. Display Pay Slip
                        11. Log out
                        """);
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1 -> addStudent(input);
                    case 2 -> removeStudent(input);
                    case 3 -> editStudent(input);
                    case 4 -> addFaculty(input);
                    case 5 -> removeFaculty(input);
                    case 6 -> editFaculty(input);
                    case 7 -> addStaff(input);
                    case 8 -> removeStaff(input);
                    case 9 -> editStaff(input);
                    case 10 -> displayPaySlip(input);
                    case 11 -> continueRunning = false;
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace(); // for debugging purposes
            }
        }
    }

    private void addStudent(Scanner input) {
        try {
            Student student = new Student();
            setCommonAttributes(student, input);
            System.out.println("Enter GPA: ");
            double gpa = input.nextDouble();
            student.setGpa(gpa);
            studentService.add(student);
            System.out.println("Added student successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add student: " + e.getMessage());
        }
    }

    private void removeStudent(Scanner input) {
        try {
            System.out.println("Enter student id: ");
            Long id = input.nextLong();
            studentService.delete(studentService.findById(id));
            System.out.println("Removed student successfully!");
        } catch (Exception e) {
            System.out.println("Failed to remove student: " + e.getMessage());
        }
    }

    private void editStudent(Scanner input) {
        try {
            System.out.println("Enter student id: ");
            Long id = input.nextLong();
            Student student = studentService.findById(id);
            editCommonAttributes(student, input);
            studentService.update(student);
            System.out.println("Edited student successfully!");
        } catch (Exception e) {
            System.out.println("Failed to edit student: " + e.getMessage());
        }
    }

    private void addFaculty(Scanner input) {
        try {
            Faculty faculty = new Faculty();
            setCommonAttributes(faculty, input);
            System.out.println("Enter base salary: ");
            double baseSalary = input.nextDouble();
            faculty.setBaseSalary(baseSalary);
            System.out.println("Choose faculty type: \n1.Tuition\n2.ASSOCIATE");
            int choice = input.nextInt();
            if (choice == 1) {
                faculty.setFacultyType(FacultyType.TUITION);
            } else if (choice == 2) {
                faculty.setFacultyType(FacultyType.ASSOCIATE);
            } else {
                System.out.println("Wrong option");
            }
            facultyService.save(faculty);
            System.out.println("Added faculty successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add faculty: " + e.getMessage());
        }
    }

    private void removeFaculty(Scanner input) {
        try {
            System.out.println("Enter faculty id: ");
            Long id = input.nextLong();
            facultyService.delete(facultyService.findById(id));
            System.out.println("Removed faculty successfully!");
        } catch (Exception e) {
            System.out.println("Failed to remove faculty: " + e.getMessage());
        }
    }

    private void editFaculty(Scanner input) {
        try {
            System.out.println("Enter faculty id: ");
            Long id = input.nextLong();
            Faculty faculty = facultyService.findById(id);
            editCommonAttributes(faculty, input);
            Scanner newInput = new Scanner(System.in);
            System.out.println("Enter new base salary: ");
            double baseSalary = newInput.nextDouble();
            faculty.setBaseSalary(baseSalary);
            facultyService.update(faculty);
            System.out.println("Edited faculty successfully!");
        } catch (Exception e) {
            System.out.println("Failed to edit faculty: " + e.getMessage());
        }
    }

    private void addStaff(Scanner input) {
        try {
            Staff staff = new Staff();
            setCommonAttributes(staff, input);
            System.out.println("Enter salary: ");
            double salary = input.nextDouble();
            staff.setSalary(salary);
            staffService.add(staff);
            System.out.println("Added staff successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add staff: " + e.getMessage());
        }
    }

    private void removeStaff(Scanner input) {
        try {
            System.out.println("Enter staff id: ");
            Long id = input.nextLong();
            staffService.deleteById(id);
            System.out.println("Removed staff successfully!");
        } catch (Exception e) {
            System.out.println("Failed to remove staff: " + e.getMessage());
        }
    }

    private void editStaff(Scanner input) {
        try {
            System.out.println("Enter staff id: ");
            Long id = input.nextLong();
            Staff staff = staffService.findById(id);
            editCommonAttributes(staff, input);
            Scanner newInput = new Scanner(System.in);
            System.out.println("Enter new salary: ");
            double salary = newInput.nextDouble();
            staff.setSalary(salary);
            staffService.update(staff);
            System.out.println("Edited staff successfully!");
        } catch (Exception e) {
            System.out.println("Failed to edit staff: " + e.getMessage());
        }
    }

    private void setCommonAttributes(Person person, Scanner input) {
        try {
            System.out.println("Enter first name: ");
            String firstName = input.nextLine();
            System.out.println("Enter last name: ");
            String lastName = input.nextLine();
            System.out.println("Enter national code: ");
            Integer nationalCode = input.nextInt();
            System.out.println("Enter phone number: ");
            Integer phoneNumber = input.nextInt();
            input.nextLine(); // Consume newline left-over
            System.out.println("Enter username: ");
            String username = input.nextLine();
            System.out.println("Enter password: ");
            String password = input.nextLine();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setNationalCode(nationalCode);
            person.setPhoneNumber(phoneNumber);
            person.setUsername(username);
            person.setPassword(password);
        } catch (Exception e) {
            System.out.println("Failed to set common attributes: " + e.getMessage());
        }
    }

    private void editCommonAttributes(Person person, Scanner input) {
        try {
            System.out.println("1. First Name: " + person.getFirstName());
            System.out.println("2. Last Name: " + person.getLastName());
            System.out.println("3. National Code: " + person.getNationalCode());
            System.out.println("4. Phone Number: " + person.getPhoneNumber());
            System.out.println("5. Username: " + person.getUsername());
            System.out.println("6. Password: " + person.getPassword());
            System.out.println("Choose an attribute to edit (1-6): ");
            int option = input.nextInt();
            input.nextLine(); // Consume newline left-over
            switch (option) {
                case 1 -> {
                    System.out.println("Enter new first name: ");
                    String firstName = input.nextLine();
                    person.setFirstName(firstName);
                }
                case 2 -> {
                    System.out.println("Enter new last name: ");
                    String lastName = input.nextLine();
                    person.setLastName(lastName);
                }
                case 3 -> {
                    System.out.println("Enter new national code: ");
                    Integer nationalCode = input.nextInt();
                    person.setNationalCode(nationalCode);
                }
                case 4 -> {
                    System.out.println("Enter new phone number: ");
                    Integer phoneNumber = input.nextInt();
                    person.setPhoneNumber(phoneNumber);
                }
                case 5 -> {
                    System.out.println("Enter new username: ");
                    String username = input.nextLine();
                    person.setUsername(username);
                }
                case 6 -> {
                    System.out.println("Enter new password: ");
                    String password = input.nextLine();
                    person.setPassword(password);
                }
                default -> System.out.println("Wrong option!");
            }
        } catch (Exception e) {
            System.out.println("Failed to edit common attributes: " + e.getMessage());
        }
    }

    private void displayPaySlip(Scanner input) {
        try {
            System.out.println("Enter staff id : ");
            Long staffId = input.nextLong();
            Staff staff = staffService.findById(staffId);
            System.out.println("First name : " + staff.getFirstName());
            System.out.println("Last name : " + staff.getLastName());
            System.out.println("National Code : " + staff.getNationalCode());
            System.out.println("Phone Number : " + staff.getPhoneNumber());
            System.out.println("Month Salary : " + staff.getSalary());
        } catch (Exception e) {
            System.out.println("Failed to display pay slip: " + e.getMessage());
        }
    }
}