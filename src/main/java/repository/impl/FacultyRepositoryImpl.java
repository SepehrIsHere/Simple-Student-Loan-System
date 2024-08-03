package repository.impl;

import entity.Faculty;
import jakarta.persistence.EntityManager;
import repository.FacultyRepository;

public class FacultyRepositoryImpl extends BaseEntityRepositoryImpl<Faculty> implements FacultyRepository  {
    private final EntityManager em;

    public FacultyRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }
}
