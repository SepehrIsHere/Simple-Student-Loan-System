package repository.impl;

import entity.Faculty;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.FacultyRepository;
import util.TransactionUtil;

import java.util.List;

public class FacultyRepositoryImpl<T extends Faculty> implements FacultyRepository<Faculty>, TransactionUtil {
    private final EntityManager em;

    public FacultyRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Faculty entity) {
        beginTransaction();
        em.persist(entity);
        commitTransaction();
    }

    @Override
    public void delete(Faculty entity) {
        beginTransaction();
        em.remove(entity);
        commitTransaction();
    }

    @Override
    public void update(Faculty entity) {
        beginTransaction();
        em.merge(entity);
        commitTransaction();
    }

    @Override
    public Faculty findById(Long id) {
        return em.find(Faculty.class, id);
    }

    @Override
    public List<Faculty> findAll() {
        return em.createQuery("from Faculty", Faculty.class).getResultList();
    }

    @Override
    public void beginTransaction() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
    }

    @Override
    public void commitTransaction() {
        EntityTransaction transaction = em.getTransaction();
        transaction.commit();
    }
}
