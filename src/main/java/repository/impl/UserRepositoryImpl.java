package repository.impl;

import entity.Faculty;
import entity.Person;
import entity.Staff;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Student loginStudent(String username, String password) {
        TypedQuery<Student> query = em.createQuery(
                "SELECT s FROM Student s WHERE s.username = :username AND s.password = :password", Student.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    @Override
    public Faculty loginFaculty(String username, String password) {
        TypedQuery<Faculty> query = em.createQuery("SELECT f FROM Faculty f WHERE f.username = :username AND f.password = :password", Faculty.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    @Override
    public Staff loginStaff(String username, String password) {
        TypedQuery<Staff> query = em.createQuery(
                "from Staff s where s.username = :username and s.password = :password", Staff.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }
}
