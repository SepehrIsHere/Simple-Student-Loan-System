package repository.impl;

import entity.Faculty;
import jakarta.persistence.EntityManager;
import repository.FacultyRepository;

import java.util.List;

public class FacultyRepositoryImpl extends BaseEntityRepositoryImpl<Faculty> implements FacultyRepository  {
    private final EntityManager em;

    public FacultyRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public Faculty findById(Long id) {
        return em.find(Faculty.class, id);
    }

    @Override
    public List<Faculty> findAll() {
        return em.createQuery("from Faculty", Faculty.class).getResultList();
    }
}
