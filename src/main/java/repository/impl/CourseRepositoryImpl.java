package repository.impl;

import entity.Course;
import entity.Faculty;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import repository.CourseRepository;
import util.TransactionUtil;
import entity.Course;

import java.util.List;

public class CourseRepositoryImpl<T extends Course> extends BaseEntityRepositoryImpl<Course> implements CourseRepository {
    private final EntityManager em;

    public CourseRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public List<Course> findByCourseName(String courseName) {
        TypedQuery<Course> query = em.createQuery("from Course c where c.courseName = :courseName", Course.class);
        query.setParameter("courseName", courseName);
        return query.getResultList();
    }

    @Override
    public List<Course> findByFacultyId(Long facultyId) {
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c JOIN c.faculty f WHERE f.id = :facultyId", Course.class);
        query.setParameter("facultyId", facultyId);
        return query.getResultList();
    }

}
