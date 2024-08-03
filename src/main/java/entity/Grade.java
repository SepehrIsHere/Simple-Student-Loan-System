package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = Grade.TABLE_NAME)
public class Grade extends BaseEntity {
    public static final String TABLE_NAME = "grade";

    @ManyToOne
    @Column
    private Student student;

    @ManyToOne
    @Column
    private Course course;

    @Column
    private double grade;
}
