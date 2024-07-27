package repository.impl;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.UserRepository;
import util.TransactionUtil;

import java.util.List;

public class UserRepositoryImpl<T extends User> implements UserRepository<User>, TransactionUtil {
    private final EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(User user) {
        beginTransaction();
        em.persist(user);
        commitTransaction();
    }

    @Override
    public void update(User user) {
        beginTransaction();
        em.merge(user);
        commitTransaction();
    }

    @Override
    public void delete(User user) {
        beginTransaction();
        em.remove(user);
        commitTransaction();
    }

    @Override
    public List<User> getAll() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        return em.find(User.class, username);
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
