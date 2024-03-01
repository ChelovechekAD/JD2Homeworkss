package org.ITAcademy.DAO.impl;

import org.ITAcademy.DAO.PeopleDAO;
import org.ITAcademy.entities.People;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

public class PeopleDAOImpl extends DAOImpl<People> implements PeopleDAO {

    @Override
    protected Class<People> getClazz() {
        return People.class;
    }

    @Override
    public People increaseAge(int id, int increment) {
        People people = transactionHelper.find(getClazz(), id);
        if (people == null) {
            return null;
        }
        //people.setAge(people.getAge() + increment);

        CriteriaBuilder criteriaBuilder = transactionHelper.entityManager().getCriteriaBuilder();
        CriteriaUpdate<People> peopleCriteriaUpdate = criteriaBuilder.createCriteriaUpdate(getClazz());
        Root<People> root = peopleCriteriaUpdate.from(getClazz());

        transactionHelper.begin();
        try {
            //Тренд: Превратить простое решение в большое и не нужное.
            peopleCriteriaUpdate
                    .set("age", people.getAge() + increment)
                    .where(criteriaBuilder.equal(root.get("id"), people.getId()));
            transactionHelper.entityManager().createQuery(peopleCriteriaUpdate).executeUpdate();
            transactionHelper.entityManager().refresh(people);
            //transactionHelper.merge(people);
            transactionHelper.commit();

        } catch (Exception e) {
            transactionHelper.rollback();
            e.printStackTrace();
            return null;
        }
        return people;
    }
}
