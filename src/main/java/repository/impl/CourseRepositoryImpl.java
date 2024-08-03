package repository.impl;

import entity.Course;
import entity.Faculty;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.CourseRepository;
import util.TransactionUtil;

import java.util.List;

public class CourseRepositoryImpl <T extends Course> implements CourseRepository<Course> , TransactionUtil {
    private final EntityManager em;

    public CourseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Course course) {
        beginTransaction();
        em.persist(course);
        commitTransaction();
    }

    @Override
    public void delete(Course course) {
        beginTransaction();
        em.remove(course);
        commitTransaction();
    }

    @Override
    public void update(Course course) {
        beginTransaction();
        em.merge(course);
        commitTransaction();
    }

    @Override
    public List<Course> findAll() {
        return em.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    @Override
    public Course findByCourseName(String courseName) {
        return em.find(Course.class, courseName);
    }

    @Override
    public Course findByFacultyId(Faculty faculty) {
       return em.find(Course.class, faculty.getFaculty_id());
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
