package repository.impl;

import entity.Staff;
import jakarta.persistence.EntityManager;
import repository.StaffRepository;


public class StaffRepositoryImpl extends BaseEntityRepositoryImpl<Staff> implements StaffRepository {
    private final EntityManager em;

    public StaffRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

}
