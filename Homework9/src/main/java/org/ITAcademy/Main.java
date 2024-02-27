package org.ITAcademy;

import org.ITAcademy.DAO.AddressDAO;
import org.ITAcademy.DAO.PeopleDAO;
import org.ITAcademy.DAO.impl.AddressDAOImpl;
import org.ITAcademy.DAO.impl.PeopleDAOImpl;

public class Main {
    public static void main(String[] args) {

        AddressDAO addressDAO = new AddressDAOImpl();
        PeopleDAO peopleDAO = new PeopleDAOImpl();



    }
}