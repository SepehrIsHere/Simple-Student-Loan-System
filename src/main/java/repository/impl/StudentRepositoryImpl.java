package repository.impl;

import entity.Staff;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.StudentRepository;
import util.TransactionUtil;

import java.util.List;

public class StudentRepositoryImpl <T extends Student> implements StudentRepository<Student>,TransactionUtil {
    private final EntityManager em;

    public StudentRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Student entity) {
        beginTransaction();
        em.persist(entity);
        commitTransaction();
    }

    @Override
    public void delete(Student entity) {
        beginTransaction();
        em.remove(entity);
        commitTransaction();
    }

    @Override
    public void update(Student entity) {
        beginTransaction();
        em.merge(entity);
        commitTransaction();
    }

    @Override
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findByLastName(String lastName) {
        return em.find(Student.class, lastName);
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
