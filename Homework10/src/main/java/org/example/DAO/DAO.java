package org.example.DAO;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable>{

    T save(T t);
    T get(Integer id, Class<T> tClass);
    List<T> getAllByFieldValue(String str);
    void update(T t);
    void deleteById(Integer id, Class<T> tClass);
    void deleteByFieldValue(String name);

}
