package repository.impl;

import entity.Faculty;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.FacultyRepository;
import util.TransactionUtil;

import java.util.List;

public class FacultyRepositoryImpl extends BaseEntityRepositoryImpl<Faculty> implements FacultyRepository  {
    private final EntityManager em;

    public FacultyRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }
}
