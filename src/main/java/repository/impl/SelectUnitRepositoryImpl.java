package repository.impl;

import entity.Course;
import entity.SelectUnit;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.commons.lang3.reflect.Typed;
import repository.SelectUnitRepository;

import java.util.List;

public class SelectUnitRepositoryImpl extends BaseEntityRepositoryImpl<SelectUnit> implements SelectUnitRepository {
    private final EntityManager em;

    public SelectUnitRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public List<SelectUnit> findByStudent(Long studentId) {
        TypedQuery<SelectUnit> query = em.createQuery("SELECT g FROM SelectUnit g WHERE g.student.id = :studentId", SelectUnit.class);
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public List<SelectUnit> findByCourse(Long courseId) {
        TypedQuery<SelectUnit> query = em.createQuery("SELECT g FROM SelectUnit g WHERE g.course.id = :courseId", SelectUnit.class);
        query.setParameter("courseId", courseId);
        return query.getResultList();
    }

    @Override
    public SelectUnit findById(Long id) {
        return em.find(SelectUnit.class, id);
    }

    @Override
    public List<SelectUnit> findAll() {
        return em.createQuery("from SelectUnit", SelectUnit.class).getResultList();
    }

    @Override
    public SelectUnit findByCourseAndStudent(Long courseId, Long studentId) {
        TypedQuery<SelectUnit> query = em.createQuery("SELECT s from SelectUnit JOIN Course c JOIN Student  s where c.id = :courseId and s.id = :studentId", SelectUnit.class);
        query.setParameter("courseId", courseId);
        query.setParameter("studentId", studentId);
        return query.getSingleResult();
    }
}
