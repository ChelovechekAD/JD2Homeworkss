package org.example.DAO;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable> {

    T save(T t);

    T get(Integer id);

    <R extends T> List<T> getAllByFieldValue(String attr, String embeddedTableName, String value, Class<R> tClass);

    void update(T t);

    boolean deleteById(Integer id);

    <R> boolean deleteAllByFieldValue(String attr, String embeddedTableName, String value, Class<R> tClass);

}
