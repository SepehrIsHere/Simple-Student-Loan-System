package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = SelectUnit.TABLE_NAME)
public class SelectUnit extends BaseEntity {
    public static final String TABLE_NAME = "grade";

    @ManyToOne
    @JoinColumn(name = "student_id")
    @NotNull(message = "SelectUnit must have a student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @NotNull(message = "Select unit must have a course")
    private Course course;

    @Column
    @ColumnDefault("0")
    @Min(value = 0, message = "Minimum grade cant be less than 0")
    @Max(value = 20, message = "Maximum grade cant be more than 20 ")
    private double grade;
}
