package org.ITAcademy.utilites;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("homework9");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }

    public static void closeFactory(){
        FACTORY.close();
    }

}
