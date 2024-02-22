package org.example.DAO.Impl;

import org.example.DAO.WorkTaskDAO;
import org.example.Models.WorkTask;

import javax.persistence.Query;
import java.util.List;

public class WorkTaskDAOImpl extends DAOImpl<WorkTask> implements WorkTaskDAO {
    @Override
    public List<WorkTask> getAllByFieldValue(String str) {
        return null;
    }
}
