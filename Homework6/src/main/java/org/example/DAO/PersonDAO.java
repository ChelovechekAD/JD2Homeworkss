package org.example.DAO;

import org.example.DTO.PersonDTO;

import java.util.List;

public interface PersonDAO extends DAO<PersonDTO> {
    List<PersonDTO> selectAllByAge(int age);
}
