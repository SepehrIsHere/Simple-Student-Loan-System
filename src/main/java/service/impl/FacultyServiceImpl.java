package service.impl;

import entity.Faculty;
import repository.FacultyRepository;
import service.FacultyService;

import java.util.List;

public class FacultyServiceImpl<T extends Faculty> implements FacultyService<Faculty> {
    private final FacultyRepository<Faculty> facultyRepository;

    public FacultyServiceImpl(FacultyRepository<Faculty> facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public void save(Faculty entity) {
        try {
            facultyRepository.save(entity);
        } catch (Exception e) {
            System.out.println("Error while trying to save faculty" + e.getMessage());
        }
    }

    @Override
    public void delete(Faculty entity) {
        try {
            facultyRepository.delete(entity);
        } catch (Exception e) {
            System.out.println("Error while trying to save faculty" + e.getMessage());
        }
    }

    @Override
    public void update(Faculty entity) {
        try {
            facultyRepository.save(entity);
        } catch (Exception e) {
            System.out.println("Error while trying to save faculty" + e.getMessage());
        }
    }

    @Override
    public Faculty findById(Long id) {
        try {
            return facultyRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Error while trying to get faculty" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Faculty> findAll() {
        try {
            return facultyRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error while trying to get faculty" + e.getMessage());
        }
        return null;
    }

    @Override
    public Faculty findByLastName(String lastName) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error while trying to get faculty" + e.getMessage());
        }
        return null;
    }
}
