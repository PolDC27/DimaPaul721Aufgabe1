package repository;

import java.util.List;

public interface RepositoryInterface<T> {
    void create(T obj);
    void update(T startObj, T obj);
    void delete(T obj);
    List<T> getAll();
}
