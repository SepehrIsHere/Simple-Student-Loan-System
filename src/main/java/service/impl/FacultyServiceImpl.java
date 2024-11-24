package service.impl;

import entity.Faculty;
import repository.FacultyRepository;
import service.FacultyService;

import java.util.List;

public class FacultyServiceImpl implements FacultyService<Faculty> {
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public void save(Faculty entity) {
        try {
            facultyRepository.add(entity);
        } catch (Exception e) {
            System.out.println("Exception while saving entity" + e.getMessage());
        }
    }

    @Override
    public void delete(Faculty entity) {
        try {
            facultyRepository.delete(entity);
        } catch (Exception e) {
            System.out.println("Exception while deleting entity" + e.getMessage());
        }
    }

    @Override
    public void update(Faculty entity) {
        try {
            facultyRepository.update(entity);
        } catch (Exception e) {
            System.out.println("Exception while updating entity" + e.getMessage());
        }
    }

    @Override   
    public Faculty findById(Long id) {
        try {
            return facultyRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Exception while finding entity" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Faculty> findAll() {
        try {
            facultyRepository.findAll();
        } catch (NullPointerException e) {
            System.out.println("Cannot find faculty" + e.getMessage());
        }
        return null;
    }

    @Override
    public Faculty findByLastName(String lastName) {
        try {
            facultyRepository.findByLastName(lastName);
        } catch (NullPointerException e) {
            System.out.println("Cannot find faculty " + e.getMessage());
        }
        return null;
    }
}
