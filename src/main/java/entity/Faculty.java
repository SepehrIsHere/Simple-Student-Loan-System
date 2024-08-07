package entity;

import enumeration.FacultyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Faculty.TABLE_NAME)
public class Faculty extends Person implements Serializable {
    public static final String TABLE_NAME = "faculty";
    public static final String FACULTY_ID = "faculty_id";
    public static final String ID = "faculty_id";
    public static final String COURSES_TAUGHT = "courses_taught";
    public static final String BASE_SALARY = "base_salary";


    @Enumerated(EnumType.STRING)
    @NotBlank(message = "faculty must have a type!")
    private FacultyType facultyType;

    @Column(name = COURSES_TAUGHT)
    @OneToMany
    private List<Course> coursesTaught;

    @Column(name = BASE_SALARY)
    @NotEmpty(message = "faculty must have a base salary")
    private double baseSalary;

    public Faculty(String username, String password) {
        super(username, password);
    }

    public Faculty(String firstName, String lastName, Integer nationalCode, Integer phoneNumber, String username, String password, FacultyType facultyType, Double baseSalary) {
        super(firstName, lastName, nationalCode, phoneNumber, username, password);
        this.facultyType = facultyType;
        this.baseSalary = baseSalary;

    }
}