package org.example.DAO;

import java.sql.SQLException;

public interface DAO<T> {
    T save(T object) throws SQLException;
    void update(T object) throws SQLException;
    T get(int id) throws SQLException;
    void delete(int id) throws SQLException;
}