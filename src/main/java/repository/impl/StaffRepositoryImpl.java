package repository.impl;

import entity.Faculty;
import entity.Staff;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.StaffRepository;
import util.TransactionUtil;

import java.util.List;

public class StaffRepositoryImpl<T extends Staff> implements StaffRepository<Staff>,TransactionUtil {
    private final EntityManager em;

    public StaffRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Staff entity) {
        beginTransaction();
        em.persist(entity);
        commitTransaction();
    }

    @Override
    public void delete(Staff entity) {
        beginTransaction();
        em.remove(entity);
        commitTransaction();
    }

    @Override
    public void update(Staff entity) {
        beginTransaction();
        em.merge(entity);
        commitTransaction();
    }

    @Override
    public Staff findById(Long id) {
        return em.find(Staff.class, id);
    }

    @Override
    public List<Staff> findAll() {
        return em.createQuery("from Staff", Staff.class).getResultList();
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
