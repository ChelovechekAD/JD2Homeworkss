package org.example.Utils;

import javax.persistence.EntityManager;

public class TransactionHelper<T> {

    private EntityManager entityManager;

    public TransactionHelper() {
        this.entityManager = HibernateUtil.getEntityManager();
    }

    public void begin() {
        getEntityManagerIfClosed();
        entityManager.getTransaction().begin();
    }

    public void commit() {
        try {
            validateRequest();
        } catch (Exception e) {
            System.err.println(Constants.COMMIT_ABORTED_SOMETHING_WENT_WRONG);
            return;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void rollback() {
        try {
            validateRequest();
        } catch (Exception e) {
            System.err.println(Constants.ROLLBACK_ABORTED_SOMETHING_WENT_WRONG);
            return;
        }
        entityManager.getTransaction().rollback();
        entityManager.close();
    }

    private void transactionIsActive() throws Exception {
        if (!entityManager.getTransaction().isActive()) {
            throw new Exception(Constants.TRANSACTION_IS_NOT_ACTIVE);
        }
    }

    private void entityManagerIsOpen() throws Exception {
        if (!entityManager.isOpen()) {
            throw new Exception(Constants.ENTITY_MANAGER_IS_NOT_ALIVE);
        }
    }

    private void getEntityManagerIfClosed() {
        if (!entityManager.isOpen()) {
            entityManager = HibernateUtil.getEntityManager();
        }
    }

    public EntityManager entityManager() {
        getEntityManagerIfClosed();
        return entityManager;
    }

    public void persist(T obj) {
        try {
            validateRequest();
        } catch (Exception e) {
            System.err.println(Constants.SOMETHING_WENT_WRONG_DURING_EXECUTE_TRANSACTIONS_METHODS);
            return;
        }
        entityManager.persist(obj);
    }

    public T find(Class<T> tClass, Integer id) {
        getEntityManagerIfClosed();
        return entityManager.find(tClass, id);
    }

    public void remove(T obj) {
        try {
            validateRequest();
        } catch (Exception e) {
            System.err.println(Constants.SOMETHING_WENT_WRONG_DURING_EXECUTE_TRANSACTIONS_METHODS);
            return;
        }
        entityManager.remove(obj);
    }

    public void merge(T obj) {
        try {
            validateRequest();
        } catch (Exception e) {
            System.err.println(Constants.SOMETHING_WENT_WRONG_DURING_EXECUTE_TRANSACTIONS_METHODS);
            return;
        }
        entityManager.merge(obj);
    }

    private void validateRequest() throws Exception {
        entityManagerIsOpen();
        transactionIsActive();
    }


}
