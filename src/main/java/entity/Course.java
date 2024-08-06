package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Course.TABLE_NAME)
public class Course extends BaseEntity  {
    public static final String TABLE_NAME = "course";
    public static final String COURSE_NAME = "course_name";

    @Column
    private Integer courseId;

    @Column(name = COURSE_NAME)
    private String courseName;

    @OneToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @JoinColumn(name = "lesson_id")
    @OneToOne
    private Lesson lesson;

    @Column
    private int capacity;

    @JoinColumn(name = "student_id")
    @OneToMany(mappedBy = TABLE_NAME)
    private List<Student> students;

}
