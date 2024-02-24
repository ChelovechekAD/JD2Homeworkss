package org.example.DAO;

import org.example.DTO.PersonDTO;

import java.util.List;

public interface HibernatePersonDAO {
    PersonDTO save(PersonDTO person);

    List<PersonDTO> findByColumn(String columnNameFind, Number greaterThenExclude, String columnNameOrderAsc);
}
