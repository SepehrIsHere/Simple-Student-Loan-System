package repository;

import entity.User;

import java.util.List;

public interface UserRepository<T extends User> {
    void add(T user);

    void update(T user);

    void delete(T user);

    List<T> getAll();

    T findById(Long id);

    T findByUsername(String username);
}
