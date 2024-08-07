package menu;

import entity.Faculty;
import entity.Person;
import entity.Staff;
import entity.Student;

public class MainMenu {
    private Person token;
    private final LoginMenu loginMenu;
    private final StaffMenu staffMenu;
    private final StudentMenu studentMenu;
    private final FacultyMenu facultyMenu;

    public MainMenu(LoginMenu loginMenu, StaffMenu staffMenu, StudentMenu studentMenu, FacultyMenu facultyMenu) {
        this.loginMenu = loginMenu;
        this.staffMenu = staffMenu;
        this.studentMenu = studentMenu;
        this.facultyMenu = facultyMenu;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            try {
                loginMenu.showMenu();
                token = loginMenu.getToken();
                if (token != null) {
                    boolean stayInMenu = true;
                    while (stayInMenu) {
                        try {
                            if (token instanceof Staff) {
                                staffMenu.showStaffMenu();
                            } else if (token instanceof Faculty) {
                                facultyMenu.showStudentMenu();
                            } else if (token instanceof Student) {
                                studentMenu.showStudentMenu();
                            }
                        } catch (Exception e) {
                            System.out.println("An error occurred in the submenu: " + e.getMessage());
                            e.printStackTrace(); //  for debugging purposes
                        }
                        stayInMenu = false;
                    }
                } else {
                    exit = true;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace(); //  for debugging purposes
            }
        }
        System.out.println("Exiting application");
    }
}
