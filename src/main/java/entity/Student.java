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
public class Student extends Person {
    public static final String TABLE_NAME = "student";
    public static final String ID = "student_id";
    public static final String ENROLLED_LESSONS = "enrolled_courses";


    @Column(name = ENROLLED_LESSONS)
    @ManyToMany
    private List<Course> enrolledCourses;

    public Student(String firstName, String lastName, String nationalCode, String phoneNumber, List<Course> enrolledCourses) {
        super(firstName, lastName, nationalCode, phoneNumber);
        this.enrolledCourses = enrolledCourses;
    }
}
