package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Staff.TABLE_NAME)
public class Staff extends Person implements Serializable {
    public static final String TABLE_NAME = "staff";
    public static final String STAFF_ID = "staff_id";

    @Column(name = STAFF_ID)
    private String staffId;

    @Column
    private Double salary;
}
