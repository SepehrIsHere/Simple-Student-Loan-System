package entity;

import enumeration.TermSeason;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Term extends BaseEntity {
    public static final String TERM_SEASON = "term_season";
    public static final String IS_ACTIVE = "is_active";

    @Column(name = TERM_SEASON)
    @Enumerated(EnumType.STRING)
    private TermSeason termSeason;

    @Column
    private int year;

    @Column(name = IS_ACTIVE)
    private boolean isActive;
}
