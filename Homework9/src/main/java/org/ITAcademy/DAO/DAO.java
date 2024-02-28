package org.ITAcademy.DAO;

import java.io.Serializable;

public interface DAO<T extends Serializable> {

    T create(T obj);

    T read(int id);

    T update(T obj);

    boolean delete(int id);

}
