package org.example;

import org.example.DAO.DAO;
import org.example.DAO.Impl.HomeTaskDAOImpl;
import org.example.Models.Address;
import org.example.Models.HomeTask;
import org.example.Utils.HibernateUtil;

/**
 * Hello world!
 */
public class App {

    public static final DAO<HomeTask> homeTaskDAO = new HomeTaskDAOImpl();
    public static void main(String[] args)  {



        HomeTask homeTask = new HomeTask();
        homeTask.setDescription("Nothing");
        homeTask.setName("Task10");
        homeTask.setAddress(getHomeAddress());

        homeTaskDAO.deleteById(1, HomeTask.class);
        homeTaskDAO.deleteById(6, HomeTask.class);
        homeTaskDAO.getAllByFieldValue("Task10").forEach(System.out::println);
        homeTaskDAO.save(homeTask);



        HibernateUtil.close();
    }

    public static Address getHomeAddress(){
        return new Address("Volgogradskaia", " Minsk");
    }
}
