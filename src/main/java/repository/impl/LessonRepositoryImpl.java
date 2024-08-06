package repository.impl;

import entity.Course;
import entity.Lesson;
import jakarta.persistence.EntityManager;
import repository.LessonRepository;

import java.util.List;

public class LessonRepositoryImpl extends  BaseEntityRepositoryImpl<Lesson> implements LessonRepository {
    private final EntityManager em;

    public LessonRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public Lesson findById(Long id) {
        return em.find(Lesson.class, id);
    }

    @Override
    public List<Lesson> findAll() {
        return List.of();
    }
}
