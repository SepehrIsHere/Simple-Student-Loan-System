package service.impl;

import entity.Course;
import entity.SelectUnit;
import entity.Student;
import repository.SelectUnitRepository;
import service.SelectUnitService;

import java.util.List;

public class SelectUnitServiceImpl implements SelectUnitService<SelectUnit> {
    private final SelectUnitRepository selectUnitRepository;

    public SelectUnitServiceImpl(SelectUnitRepository selectUnitRepository) {
        this.selectUnitRepository = selectUnitRepository;
    }

    @Override
    public void add(SelectUnit entity) {
        try {
            selectUnitRepository.add(entity);
        } catch (Exception e) {
            System.out.println("Exception while trying to add grade" + e.getMessage());
        }
    }

    @Override
    public void delete(SelectUnit entity) {
        try{
            selectUnitRepository.delete(entity);
        }catch(Exception e){
            System.out.println("Exception while trying to delete grade" + e.getMessage());
        }
    }

    @Override
    public void update(SelectUnit entity) {
        try{
            selectUnitRepository.update(entity);
        }catch(Exception e){
            System.out.println("Exception while trying to update grade" + e.getMessage());
        }
    }

    @Override
    public SelectUnit findById(Long id) {
        try{
            return selectUnitRepository.findById(id);
        }catch(Exception e){
            System.out.println("Exception while trying to find grade" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<SelectUnit> findAll() {
        try{
            return selectUnitRepository.findAll();
        }catch(Exception e){
            System.out.println("Exception while trying to find grade" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<SelectUnit> findByStudentId(Student student) {
        try{
            selectUnitRepository.findByStudent(student.getId());
        }catch(Exception e){
            System.out.println("Exception while trying to find grade" + e.getMessage());
        }
        return null;
    }

    @Override
    public SelectUnit findByCourseAndStudent(Long courseId, Long studentId) {
        try{
            return selectUnitRepository.findByCourseAndStudent(courseId, studentId);
        }catch (Exception e){
            System.out.println("Exception while trying to find grade" + e.getMessage());
        }
        return null;
    }
}
