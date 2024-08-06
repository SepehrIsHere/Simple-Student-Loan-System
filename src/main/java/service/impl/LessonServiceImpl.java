package service.impl;

import entity.Lesson;
import repository.LessonRepository;
import service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService<Lesson> {
    private final LessonRepository repository;

    public LessonServiceImpl(LessonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Lesson lesson) {
        try {
            repository.add(lesson);
        } catch (Exception e) {
            System.out.println("Error while adding lesson" + e.getMessage());
        }
    }

    @Override
    public void update(Lesson lesson) {
        try {
            repository.update(lesson);
        } catch (Exception e) {
            System.out.println("Error while updating lesson" + e.getMessage());
        }
    }

    @Override
    public void delete(Lesson lesson) {
        try {
            repository.delete(lesson);
        } catch (Exception e) {
            System.out.println("Error while deleting lesson" + e.getMessage());
        }
    }

    @Override
    public List<Lesson> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            System.out.println("Error while finding all " + e.getMessage());
        }
        return null;
    }

    @Override
    public Lesson findById(Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.out.println("Error while finding " + e.getMessage());
        }
        return null;
    }
}
