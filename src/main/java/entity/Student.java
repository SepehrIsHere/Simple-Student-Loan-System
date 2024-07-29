package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = Student.TABLE_NAME)
public class Student extends Person implements Serializable {
    public static final String TABLE_NAME = "student";
    public static final String ID = "student_id";
    public static final String ENROLLED_LESSONS = "enrolled_courses";

    @Column(name = ID)
    private String studentId;

    @Column
    private double gpa;

    @Column(name = ENROLLED_LESSONS)
    @ManyToMany
    private List<Course> enrolledLessons;

    public Student(String firstName, String lastName, String nationalCode, String phoneNumber, String studentId, double gpa, List<Course> enrolledLessons) {
        super(firstName, lastName, nationalCode, phoneNumber);
        this.studentId = studentId;
        this.gpa = gpa;
        this.enrolledLessons = enrolledLessons;
    }
}
