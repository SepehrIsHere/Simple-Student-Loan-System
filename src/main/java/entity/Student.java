package entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = Student.TABLE_NAME)
public class Student extends Person {
    public static final String TABLE_NAME = "student";
    public static final String ID = "student_id";
    public static final String SELECTED_UNITS = "selected_units_id";
    public static final String ALLOWED_UNIT_COUNT = "allowed_unit_count";

    @Column
    @ColumnDefault("0")
    private Double gpa;

    @Column(name = ALLOWED_UNIT_COUNT)
    @ColumnDefault("20")
    private Integer allowedUnitCount;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    @OneToMany(mappedBy = "student")
    private List<SelectUnit> selectedUnits;
}
