package org.ITAcademy.DAO.impl;

import org.ITAcademy.DAO.PeopleDAO;
import org.ITAcademy.entities.People;

public class PeopleDAOImpl extends DAOImpl<People> implements PeopleDAO {

    @Override
    protected Class<People> getClazz() {
        return People.class;
    }

    @Override
    public People increaseAge(int id, int increment) {
        People people = transactionHelper.find(getClazz(), id);
        people.setAge(people.getAge() + increment);
        transactionHelper.begin();
        try {
            transactionHelper.merge(people);
            transactionHelper.commit();
        } catch (Exception e) {
            transactionHelper.rollback();
            e.printStackTrace();
            return null;
        }
        return people;
    }
}
