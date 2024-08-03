package service.impl;

import entity.Course;
import entity.Grade;
import entity.Student;
import repository.GradeRepository;
import repository.StudentRepository;
import service.GradeService;
import util.TransactionUtil;

import java.util.List;

public class GradeServiceImpl <T extends Grade> implements GradeService<Grade>{
    private final GradeRepository<Grade> gradeRepository;
    private final StudentRepository<Student> studentRepository;

    public GradeServiceImpl(GradeRepository<Grade> gradeRepository, StudentRepository<Student> studentRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(Grade entity) {
        try {
            gradeRepository.add(entity);
        }catch (RuntimeException e) {
            System.out.println("Error while trying to save grade" + e.getMessage());
        }
    }

    @Override
    public void delete(Grade entity) {
        try{
            gradeRepository.delete(entity);
        }catch (RuntimeException e) {
            System.out.println("Error while trying to save grade" + e.getMessage());
        }
    }

    @Override
    public void update(Grade entity) {
        try {
            gradeRepository.update(entity);
        }catch (RuntimeException e) {
            System.out.println("Error while trying to save grade" + e.getMessage());
        }
    }

    @Override
    public Grade findById(Long id) {
        try {
            return gradeRepository.getById(id);
        }catch (RuntimeException e) {
            System.out.println("Error while trying to get grade" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Grade> findAll() {
        try {
            return gradeRepository.getAll();
        }catch (RuntimeException e) {
            System.out.println("Error while trying to get grade" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Grade> findByStudentId(Student student) {
        try {
            Student student1 = studentRepository.findById(student.getStudentId());
            return gradeRepository.findByStudent(student1);
        }catch (RuntimeException e) {
            System.out.println("Error while trying to get grade" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Grade> findByCourseId(Course course) {
        return gradeRepository.findByCourse()
    }
}
