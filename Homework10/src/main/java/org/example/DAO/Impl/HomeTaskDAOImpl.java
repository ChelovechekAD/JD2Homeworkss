package org.example.DAO.Impl;

import org.example.DAO.HomeTaskDAO;
import org.example.Models.HomeTask;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class HomeTaskDAOImpl extends DAOImpl<HomeTask> implements HomeTaskDAO {
    @Override
    public List<HomeTask> getAllByFieldValue(String str) {
        transactionHelper.begin();
        TypedQuery<HomeTask> q = transactionHelper.entityManager().createQuery("select h from HomeTask h where h.name =  ?1", HomeTask.class);
        q.setParameter(1, str);
        List<HomeTask> out = q.getResultStream().collect(Collectors.toList());
        transactionHelper.commit();
        return out;
    }
}
