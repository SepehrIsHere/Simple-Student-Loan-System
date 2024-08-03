package service.impl;

import entity.Course;
import entity.Grade;
import entity.Student;
import repository.GradeRepository;
import service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService<Grade> {
    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public void add(Grade entity) {
        try {
            gradeRepository.add(entity);
        } catch (Exception e) {
            System.out.println("Exception while trying to add grade" + e.getMessage());
        }
    }

    @Override
    public void delete(Grade entity) {
        try{
            gradeRepository.delete(entity);
        }catch(Exception e){
            System.out.println("Exception while trying to delete grade" + e.getMessage());
        }
    }

    @Override
    public void update(Grade entity) {
        try{
            gradeRepository.update(entity);
        }catch(Exception e){
            System.out.println("Exception while trying to update grade" + e.getMessage());
        }
    }

    @Override
    public Grade findById(Class<Grade> entity, Long id) {
        try{
            return gradeRepository.findById(entity, id);
        }catch(Exception e){
            System.out.println("Exception while trying to find grade" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Grade> findAll(Class<Grade> entity) {
        try{
            return gradeRepository.findAll(entity);
        }catch(Exception e){
            System.out.println("Exception while trying to find grade" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Grade> findByStudentId(Student student) {
        try{
            gradeRepository.findByStudent(student.getId());
        }catch(Exception e){
            System.out.println("Exception while trying to find grade" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Grade> findByCourseId(Course course) {
        try{
            gradeRepository.findByCourse(course.getId());
        }catch(Exception e){
            System.out.println("Exception while trying to find grade" + e.getMessage());
        }
        return null;
    }
}
