package repository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> implements RepositoryInterface<T> {
    private final List<T> data = new ArrayList<>();

    @Override
    public void create(T object) {
        data.add(object);
    }


    public List<T> getAll(){
        return data;
    }


    public void delete(T object) {
        data.remove(object);
    }


    public void update(T startObject, T object) {
        data.set(data.indexOf(startObject), object);
    }

}
