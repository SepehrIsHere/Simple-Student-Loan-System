package repository.impl;

import entity.Faculty;
import entity.Staff;
import entity.Student;
import jakarta.persistence.NoResultException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.UserRepository;
import service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginStudent_Success() {
        Student student = new Student();
        student.setUsername("testStudent");
        student.setPassword("password");

        // Mock the repository response
        when(userRepository.loginStudent(anyString(), anyString())).thenReturn(student);

        Student result = userService.loginStudent(student);
        assertNotNull(result);
        assertEquals("testStudent", result.getUsername());
    }

    @Test
    public void testLoginStudent_Failure() {
        Student student = new Student();
        student.setUsername("testStudent");
        student.setPassword("wrongPassword");

        // Mock the repository to throw NoResultException
        when(userRepository.loginStudent(anyString(), anyString())).thenThrow(new NoResultException());

        Student result = userService.loginStudent(student);
        assertNull(result);
    }

    @Test
    public void testLoginFaculty_Success() {
        Faculty faculty = new Faculty();
        faculty.setUsername("testFaculty");
        faculty.setPassword("password");

        // Mock the repository response
        when(userRepository.loginFaculty(anyString(), anyString())).thenReturn(faculty);

        Faculty result = userService.loginFaculty(faculty);
        assertNotNull(result);
        assertEquals("testFaculty", result.getUsername());
    }

    @Test
    public void testLoginFaculty_Failure() {
        Faculty faculty = new Faculty();
        faculty.setUsername("testFaculty");
        faculty.setPassword("wrongPassword");

        // Mock the repository to throw NoResultException
        when(userRepository.loginFaculty(anyString(), anyString())).thenThrow(new NoResultException());

        Faculty result = userService.loginFaculty(faculty);
        assertNull(result);
    }

    @Test
    public void testLoginStaff_Success() {
        Staff staff = new Staff();
        staff.setUsername("testStaff");
        staff.setPassword("password");

        // Mock the repository response
        when(userRepository.loginStaff(anyString(), anyString())).thenReturn(staff);

        Staff result = userService.loginStaff(staff);
        assertNotNull(result);
        assertEquals("testStaff", result.getUsername());
    }

    @Test
    public void testLoginStaff_Failure() {
        Staff staff = new Staff();
        staff.setUsername("testStaff");
        staff.setPassword("wrongPassword");

        // Mock the repository to throw NoResultException
        when(userRepository.loginStaff(anyString(), anyString())).thenThrow(new NoResultException());

        Staff result = userService.loginStaff(staff);
        assertNull(result);
    }
}
