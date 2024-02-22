package org.example.Utils;


import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY_MYSQL = Persistence.createEntityManagerFactory("hibernatePostgres");

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY_MYSQL.createEntityManager();
    }

    public static void close() {
        ENTITY_MANAGER_FACTORY_MYSQL.close();
    }

}

