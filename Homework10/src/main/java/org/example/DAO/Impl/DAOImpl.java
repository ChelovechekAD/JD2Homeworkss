package org.example.DAO.Impl;

import org.example.DAO.DAO;
import org.example.Utils.TransactionHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class DAOImpl<T extends Serializable> implements DAO<T> {

    EntityManager entityManager;
    TransactionHelper<T> transactionHelper;

    {
        transactionHelper = new TransactionHelper<>();
    }

    @Override
    public T save(T t) {
        transactionHelper.begin();
        try {
            transactionHelper.persist(t);
        } catch (Exception e) {
            e.printStackTrace();
            transactionHelper.rollback();
        }
        transactionHelper.commit();
        return t;
    }

    @Override
    public T get(Integer id, Class<T> tClass) {
        T out = null;
        out = transactionHelper.find(tClass, id);
        return out;
    }

    @Override
    public List<T> getAllByFieldValue(String str) {
        return null;
    }

    @Override
    public void update(T t) {
        transactionHelper.begin();
        try {
            transactionHelper.merge(t);
        } catch (Exception e) {
            e.printStackTrace();
            transactionHelper.rollback();
        }
        transactionHelper.commit();
    }

    @Override
    public void deleteById(Integer id, Class<T> tClass) {
        transactionHelper.begin();
        try {
            Optional.ofNullable(transactionHelper.find(tClass, id))
                    .ifPresent(l -> transactionHelper.remove(l));
        } catch (Exception e) {
            e.printStackTrace();
            transactionHelper.rollback();

        }

        transactionHelper.commit();
    }


    @Override
    public void deleteByFieldValue(String name) {
        transactionHelper.begin();

    }


}
