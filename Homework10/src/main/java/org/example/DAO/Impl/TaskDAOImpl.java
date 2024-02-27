package org.example.DAO.Impl;

import org.example.DAO.TaskDAO;
import org.example.Models.Task;

public class TaskDAOImpl extends DAOImpl<Task> implements TaskDAO {

    @Override
    protected Class<Task> getClazz() {
        return Task.class;
    }
}
