package repository;

import java.util.List;

public interface BaseEntityRepository<T> {
    void add(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(Long id);

}
