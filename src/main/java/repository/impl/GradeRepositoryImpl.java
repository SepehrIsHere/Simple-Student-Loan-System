package repository.impl;

import entity.Course;
import entity.Grade;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import repository.GradeRepository;
import util.TransactionUtil;

import java.util.List;

public class GradeRepositoryImpl extends BaseEntityRepositoryImpl<Grade> implements GradeRepository {
    private final EntityManager em;

    public GradeRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public List<Grade> findByStudent(Long studentId) {
        TypedQuery<Grade> query = em.createQuery("SELECT g FROM Grade g WHERE g.student.id = :studentId", Grade.class);
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public List<Grade> findByCourse(Long courseId) {
        TypedQuery<Grade> query = em.createQuery("SELECT g FROM Grade g WHERE g.course.id = :courseId", Grade.class);
        query.setParameter("courseId", courseId);
        return query.getResultList();
    }
}
