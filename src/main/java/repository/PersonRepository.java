package repository;

import entity.Person;

import java.util.List;

public interface PersonRepository<T extends Person> {
    void save(T person);

    void delete(T person);

    void update(T person);

    T findById(Long id);

    List<T> findAll();

    T findByLastName(String lastName);

}
