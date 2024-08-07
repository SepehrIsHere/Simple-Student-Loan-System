package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = Staff.TABLE_NAME)
public class Staff extends Person  {
    public static final String TABLE_NAME = "staff";
    public static final String STAFF_ID = "staff_id";

    @Column
    @NotBlank(message = "Salary cannot be blank!")
    private Double salary;

    public Staff(String firstName,String lastName, Integer nationalCode,Integer phoneNumber,String username,String password,Double salary){
        super(firstName,lastName,nationalCode,phoneNumber,username,password);
        this.salary = salary;
    }
    public Staff(String username,String password){
        super(username,password);
    }
}
