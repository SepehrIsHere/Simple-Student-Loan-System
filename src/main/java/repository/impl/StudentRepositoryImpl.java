package repository.impl;

import entity.Course;
import entity.SelectUnit;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.commons.lang3.reflect.Typed;
import repository.StudentRepository;

import java.util.List;

public class StudentRepositoryImpl extends BaseEntityRepositoryImpl<Student> implements StudentRepository {
    private final EntityManager em;

    public StudentRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public Student findByLastName(String lastName) {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.lastName = :lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getSingleResult();
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
    public List<SelectUnit> getSelectedUnits(Student student) {
        TypedQuery<SelectUnit> query = em.createQuery(
                "SELECT cg FROM SelectUnit cg WHERE cg.student = :student", SelectUnit.class);
        query.setParameter("student", student);
        return query.getResultList();
    }

    @Override
    public List<Course> findStudentCourses(Long studentId) {
        TypedQuery<Course> query = em.createQuery(" SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId",Course.class);
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }
}
