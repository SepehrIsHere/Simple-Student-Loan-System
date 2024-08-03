package entity;

import enumeration.FacultyType;
import jakarta.persistence.*;
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
    public static final String ID  = "faculty_id";
    public static final String COURSES_TAUGHT = "courses_taught";
    public static final String BASE_SALARY = "base_salary";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long faculty_id;

    @Enumerated(EnumType.STRING)
    private FacultyType facultyType;

    @Column(name = COURSES_TAUGHT)
    @OneToMany
    private List<Course> coursesTaught;

    @Column(name = BASE_SALARY)
    private double baseSalary;
}