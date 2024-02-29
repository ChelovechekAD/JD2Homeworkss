package org.ITAcademy.utilites;

import javax.persistence.EntityManager;

public final class TransactionHelper {

    private static TransactionHelper transactionHelper;
    private EntityManager entityManager;

    private TransactionHelper() {
        this.entityManager = HibernateUtil.getEntityManager();
    }

    public static TransactionHelper getTransactionHelper() {
        if (transactionHelper == null) {
            transactionHelper = new TransactionHelper();
        }
        return transactionHelper;
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
    }

    public void rollback() {
        try {
            validateRequest();
        } catch (Exception e) {
            System.err.println(Constants.ROLLBACK_ABORTED_SOMETHING_WENT_WRONG);
            return;
        }
        entityManager.getTransaction().rollback();
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

    public <T> void persist(T obj) {
        try {
            validateRequest();
        } catch (Exception e) {
            System.err.println(Constants.SOMETHING_WENT_WRONG_DURING_EXECUTE_TRANSACTIONS_METHODS);
            return;
        }
        entityManager.persist(obj);
    }

    public <T> T find(Class<T> tClass, Integer id) {
        getEntityManagerIfClosed();
        return entityManager.find(tClass, id);
    }

    public <T> void remove(T obj) {
        try {
            validateRequest();
        } catch (Exception e) {
            System.err.println(Constants.SOMETHING_WENT_WRONG_DURING_EXECUTE_TRANSACTIONS_METHODS);
            return;
        }
        entityManager.remove(obj);
    }

    public <T> void merge(T obj) {
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