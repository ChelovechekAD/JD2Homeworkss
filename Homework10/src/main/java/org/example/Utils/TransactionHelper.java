package org.example.Utils;

import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;

public class TransactionHelper<T> {

    private EntityManager entityManager;

    public TransactionHelper() {
        this.entityManager = HibernateUtil.getEntityManager();
    }

    public void begin(){
        getEntityManagerIfClosed();
        entityManager.getTransaction().begin();
    }

    public void commit() {
        try {
            validateRequest();
        }catch (Exception e){
            System.err.println("Commit aborted. Something went wrong.");
            return;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void rollback(){
        try {
            validateRequest();
        }catch (Exception e){
            System.err.println("Rollback aborted. Something went wrong.");
            return;
        }
        entityManager.getTransaction().rollback();
        entityManager.close();
    }

    private void transactionIsActive() throws Exception {
        if (!entityManager.getTransaction().isActive()){
            throw new Exception("Transaction is not active.");
        }
    }

    private void entityManagerIsOpen() throws Exception {
        if (!entityManager.isOpen()) {
            throw new Exception("Entity Manager is not alive.");
        }
    }

    private void getEntityManagerIfClosed() {
        if (!entityManager.isOpen()) {
            entityManager = HibernateUtil.getEntityManager();
        }
    }

    public EntityManager entityManager(){
        return entityManager;
    }

    public void persist(T obj){
        try {
            validateRequest();
        }catch (Exception e){
            System.err.println("Something went wrong during execute transaction's methods.");
            return;
        }
        entityManager.persist(obj);
    }

    public T find(Class<T> tClass, Integer id){
        try {
            entityManagerIsOpen();
        }catch (Exception e){
            System.err.println("Something went wrong during execute transaction's methods.");
            return null;
        }
        return entityManager.find(tClass, id);
    }

    public void remove(T obj){
        try {
            validateRequest();
        }catch (Exception e){
            System.err.println("Something went wrong during execute transaction's methods.");
            return;
        }
        entityManager.remove(obj);
    }

    public void merge(T obj){
        try {
            validateRequest();
        }catch (Exception e){
            System.err.println("Something went wrong during execute transaction's methods.");
            return;
        }
        entityManager.merge(obj);
    }

    private void validateRequest() throws Exception {
        entityManagerIsOpen();
        transactionIsActive();
    }


}
