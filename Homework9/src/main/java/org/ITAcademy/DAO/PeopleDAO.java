package org.ITAcademy.DAO;

import org.ITAcademy.entities.People;

public interface PeopleDAO extends DAO<People>{
    People increaseAge(int id, int increment);
}
