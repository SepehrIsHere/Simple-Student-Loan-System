package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Course extends BaseEntity {
    public static final String TABLE_NAME = "course";
    public static final String COURSE_NAME = "course_name";

    @Column
    private Integer courseId;

    @Column(name = COURSE_NAME)
    @NotBlank(message = "course must have a name!")
    private String courseName;

    @OneToOne
    @JoinColumn(name = "faculty_id")
    @NotNull(message = "course must have a faculty")
    private Faculty faculty;

    @JoinColumn(name = "lesson_id")
    @OneToOne
    @NotNull(message = "course must have a lesson")
    private Lesson lesson;

    //Useless
    @OneToMany(mappedBy = "course")
    private List<SelectUnit> selectUnits;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
}
