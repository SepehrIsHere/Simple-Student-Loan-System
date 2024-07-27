package repository.impl;

import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;
import repository.PersonRepository;
import util.TransactionUtil;

import java.util.List;

public class PersonRepositoryImpl <T extends Person> implements PersonRepository<Person>, TransactionUtil {
    private final EntityManager em;

    public PersonRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Person person) {
        beginTransaction();
        em.persist(person);
        commitTransaction();
    }

    @Override
    public void delete(Person person) {
        beginTransaction();
        em.remove(em.merge(person));
        commitTransaction();
    }

    @Override
    public void update(Person person) {
        beginTransaction();
        em.merge(person);
        commitTransaction();
    }

    @Override
    public Person findById(Long id) {
        return em.find(Person.class,id);
    }

    @Override
    public List<Person> findAll() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Override
    public Person findByLastName(String lastName) {
        return em.find(Person.class,lastName);
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
