package org.example.DAO.Impl;

import org.example.DAO.DAO;
import org.example.Utils.TransactionHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class DAOImpl<T extends Serializable> implements DAO<T> {


    protected TransactionHelper<T> transactionHelper;

    {
        transactionHelper = new TransactionHelper<>();
    }

    protected abstract Class<T> getClazz();


    @Override
    public T save(T t) {
        transactionHelper.begin();
        try {
            transactionHelper.persist(t);
            transactionHelper.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transactionHelper.rollback();
        }
        return t;
    }

    @Override
    public T get(Integer id) {
        T out = null;
        out = transactionHelper.find(getClazz(), id);
        return out;
    }

    @Override
    public <R extends T> List<T> getAllByFieldValue(String attr, String embeddedTableName, String value, Class<R> tClass) {
        EntityManager entityManager = transactionHelper.entityManager();
        List<T> list;

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<R> criteriaQuery = criteriaBuilder.createQuery(tClass);
        Root<R> root = criteriaQuery.from(tClass);
        try {
            criteriaQuery.select(root);
            Optional.ofNullable(embeddedTableName)
                    .ifPresentOrElse(
                            n -> criteriaQuery.where(criteriaBuilder.equal(root.get(n).get(attr), value)),
                            () -> criteriaQuery.where(criteriaBuilder.equal(root.get(attr), value)));


            Query query = entityManager.createQuery(criteriaQuery);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.close();
            return null;
        }
        entityManager.close();
        return list;
    }

    @Override
    public void update(T t) {
        transactionHelper.begin();
        try {
            transactionHelper.merge(t);
            transactionHelper.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transactionHelper.rollback();
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        transactionHelper.begin();
        try {
            Optional.ofNullable(transactionHelper.find(getClazz(), id))
                    .ifPresent(l -> transactionHelper.remove(l));
            transactionHelper.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transactionHelper.rollback();
            return false;
        }
        return true;

    }


    @Override
    public <R> boolean deleteAllByFieldValue(String attr, String embeddedTableName, String value, Class<R> tClass) {
        EntityManager entityManager = transactionHelper.entityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<R> criteriaDelete = criteriaBuilder.createCriteriaDelete(tClass);
        Root<R> root = criteriaDelete.from(tClass);

        try {
            transactionHelper.begin();
            Optional.ofNullable(embeddedTableName).ifPresentOrElse(
                    n -> criteriaDelete.where(criteriaBuilder.equal(root.get(n).get(attr), value)),
                    () -> criteriaDelete.where(criteriaBuilder.equal(root.get(attr), value)));
            int rowAffectedCount = entityManager.createQuery(criteriaDelete).executeUpdate();
            System.out.println(rowAffectedCount + " row affected.");
            transactionHelper.commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.close();
            return false;
        }
        return true;

    }


}
