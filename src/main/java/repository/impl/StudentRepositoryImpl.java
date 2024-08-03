package repository.impl;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repository.StudentRepository;

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

}
