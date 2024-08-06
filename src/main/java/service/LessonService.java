package service;

import entity.Lesson;

import java.util.List;

public interface LessonService<Lesson> {
    void add(Lesson lesson);

    void update(Lesson lesson);

    void delete(Lesson lesson);

    List<Lesson> findAll();

    Lesson findById(Long id);
}
