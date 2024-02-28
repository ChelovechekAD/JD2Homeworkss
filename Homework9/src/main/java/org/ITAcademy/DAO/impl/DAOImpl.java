package org.ITAcademy.DAO.impl;

import org.ITAcademy.DAO.DAO;
import org.ITAcademy.utilites.TransactionHelper;

import java.io.Serializable;

public abstract class DAOImpl<T extends Serializable> implements DAO<T> {
    protected final TransactionHelper<T> transactionHelper = new TransactionHelper<>();

    protected abstract Class<T> getClazz();

    @Override
    public T create(T obj) {
        transactionHelper.begin();
        try {
            transactionHelper.persist(obj);
            transactionHelper.commit();
        } catch (Exception e) {
            transactionHelper.rollback();
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public T read(int id) {
        return transactionHelper.find(getClazz(), id);
    }

    @Override
    public T update(T obj) {
        transactionHelper.begin();
        try {
            transactionHelper.merge(obj);
            transactionHelper.commit();
        } catch (Exception e) {
            transactionHelper.rollback();
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public boolean delete(int id) {
        T obj = transactionHelper.find(getClazz(), id);
        transactionHelper.begin();
        try {
            transactionHelper.remove(obj);
            transactionHelper.commit();
        } catch (Exception e) {
            transactionHelper.rollback();
            return false;
        }
        return true;
    }
}
