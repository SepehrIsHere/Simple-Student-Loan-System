package service.impl;

import entity.Student;
import repository.StudentRepository;
import service.StudentService;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class StudentServiceImpl implements StudentService<Student> {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void add(Student entity) {
        try{
            studentRepository.add(entity);
        }catch (Exception e){
            System.out.println("An error occured while adding a student" + e.getMessage());
        }
    }

    @Override
    public void update(Student entity) {
        try{
            studentRepository.update(entity);
        }catch (Exception e){
            System.out.println("An error occured while updating a student" + e.getMessage());
        }
    }

    @Override
    public void delete(Student entity) {
        try{
            studentRepository.delete(entity);
        }catch (Exception e){
            System.out.println("An error occured while deleting a student" + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try{
            studentRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("An error occured while deleting a student" + e.getMessage());
        }
    }

    @Override
    public Student findById(Class<Student> entity,Long id) {
        try{
            return studentRepository.findById(entity,id);
        }catch (Exception e){
            System.out.println("An error occured while finding a student" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> findAll(Class<Student> entity) {
        try {
            return studentRepository.findAll(entity);
        }catch (Exception e){
            System.out.println("An error occured while finding all students" + e.getMessage());
        }
        return null;
    }

    @Override
    public Student findByLastName(String lastName) {
        try{
            return studentRepository.findByLastName(lastName);
        }catch (Exception e){
            System.out.println("An error occured while finding a student" + e.getMessage());
        }
        return null;
    }
}
