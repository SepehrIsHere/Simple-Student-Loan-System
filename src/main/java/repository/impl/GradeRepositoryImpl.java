package repository.impl;

import entity.Course;
import entity.Grade;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.GradeRepository;
import util.TransactionUtil;

import java.util.List;

public class GradeRepositoryImpl<T extends Grade> implements GradeRepository<Grade>, TransactionUtil {
    private final EntityManager em;

    public GradeRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Grade grade) {
        beginTransaction();
        em.persist(grade);
        commitTransaction();
    }

    @Override
    public void update(Grade grade) {
        beginTransaction();
        em.merge(grade);
        commitTransaction();
    }

    @Override
    public void delete(Grade grade) {
        beginTransaction();
        em.remove(grade);
        commitTransaction();
    }

    @Override
    public List<Grade> getAll() {
        return em.createQuery("from Grade", Grade.class).getResultList();
    }

    @Override
    public Grade getById(Long id) {
        return em.find(Grade.class, id);
    }

    @Override
    public List<Grade> findByStudent(Student student) {
        return em.createQuery("from Grade where student = :student", Grade.class).setParameter("student", student).getResultList();
    }

    @Override
    public List<Grade> findByCourse(Course course) {
        return em.createQuery("from Grade where course = :course", Grade.class).setParameter("course", course).getResultList();
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
