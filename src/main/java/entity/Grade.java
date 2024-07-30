package entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;

public class Grade extends BaseEntity {
    @JoinColumn(name = Student.TABLE_NAME)
    private Student student;

    @JoinColumn(name = Course.TABLE_NAME)
    private Course course;

    @Column
    private double grade;
}
