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
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends BaseEntity implements Serializable {
    public static final String TABLE_NAME = "person";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String NATIONAL_CODE = "national_code";
    public static final String PHONE_NUMBER = "phone_number";

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = NATIONAL_CODE)
    private String nationalCode;

    @Column(name = PHONE_NUMBER)
    private String phoneNumber;

}
