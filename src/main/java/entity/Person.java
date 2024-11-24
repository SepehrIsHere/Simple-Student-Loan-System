package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
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
    @Min(value = 5, message = "cannot be less than 5")
    @Max(value = 8, message = "cannot be bigger than 8")
    //@Pattern()
    private Integer nationalCode;

    @Min(value = 5, message = "cannot be less than 5")
    @Max(value = 8, message = "cannot be bigger than 8")
    @Column(name = PHONE_NUMBER)
    private Integer phoneNumber;

    @NotBlank(message = "username cannot be blank!")
    @Column
    private String username;

    @NotBlank(message = "password cannot be blank!")
    @Column
    private String password;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public Person(String firstName, String lastName, Integer nationalCode, Integer phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
    }
}
