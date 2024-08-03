package service.impl;

import entity.Staff;
import repository.StaffRepository;
import service.StaffService;

import java.util.List;

public class StaffServiceImpl<T extends Staff> implements StaffService<Staff> {
    private final StaffRepository<Staff> staffRepository;

    public StaffServiceImpl(StaffRepository<Staff> staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public void save(Staff entity) {
        try {
            staffRepository.save(entity);
        } catch (Exception e) {
            System.out.println("Error while trying to save Staff" + e.getMessage());
        }
    }

    @Override
    public void delete(Staff entity) {
        try {
            staffRepository.delete(entity);
        } catch (Exception e) {
            System.out.println("Error while trying to save Staff" + e.getMessage());
        }
    }

    @Override
    public void update(Staff entity) {
        try {
            staffRepository.update(entity);
        } catch (Exception e) {
            System.out.println("Error while trying to save Staff" + e.getMessage());
        }
    }

    @Override
    public Staff findById(Long id) {
        try {
            return staffRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Error while trying to get Staff" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Staff> findAll() {
        try {
            return staffRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error while trying to get Staff" + e.getMessage());
        }
        return null;
    }

}
