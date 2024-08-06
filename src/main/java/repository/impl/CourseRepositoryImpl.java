package repository.impl;

import entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repository.CourseRepository;

import java.util.List;

public class CourseRepositoryImpl<T extends Course> extends BaseEntityRepositoryImpl<Course> implements CourseRepository {
    private final EntityManager em;

    public CourseRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    @Override
    public List<Course> findAll() {
        return em.createQuery("from Course", Course.class).getResultList();
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

    @Override
    public List<Course> findByCourseId(Integer courseId) {
        TypedQuery<Course> query = em.createQuery("from Course c where c.courseId = :courseId", Course.class);
        query.setParameter("courseId", courseId);
        return query.getResultList();
    }
}
