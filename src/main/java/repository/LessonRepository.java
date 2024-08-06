package repository;

import entity.Lesson;

import java.util.List;

public interface LessonRepository extends BaseEntityRepository<Lesson> {
    Lesson findById(Long id);

    List<Lesson> findAll();
}
