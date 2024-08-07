package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Lesson extends BaseEntity {

    @Column
    @NotBlank(message = "lesson must have a title")
    private String title;

    @Column
    @NotNull(message = "lesson must have a unit count")
    @Min(value = 2, message = "minimum amount must be 2")
    @Max(value = 4, message = "maximum amount must be 4")
    private Integer unit;
}
