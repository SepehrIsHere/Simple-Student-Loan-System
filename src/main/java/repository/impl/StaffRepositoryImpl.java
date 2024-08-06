package repository.impl;

import entity.Staff;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.commons.lang3.reflect.Typed;
import repository.StaffRepository;

import java.util.List;


public class StaffRepositoryImpl extends BaseEntityRepositoryImpl<Staff> implements StaffRepository {
    private final EntityManager em;

    public StaffRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public Staff findById(Long id) {
        return em.find(Staff.class, id);
    }

    @Override
    public List<Staff> findAll() {
        return em.createQuery("from Staff", Staff.class).getResultList();
    }

    @Override
    public Staff findByUsername(String username) {
        TypedQuery<Staff> query = em.createQuery("from Staff where username = :username", Staff.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public Staff login(Staff staff) {
        TypedQuery<Staff> query = em.createQuery("from Staff where username = :username and password = :password", Staff.class);
        query.setParameter("username", staff.getUsername());
        query.setParameter("password", staff.getPassword());
        return query.getSingleResult();
    }
}
