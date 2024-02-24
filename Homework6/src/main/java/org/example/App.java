package org.example;


import org.example.DAO.PersonDAO;
import org.example.DAO.PersonDAOImpl;
import org.example.DTO.PersonDTO;
import org.example.Utility.DatabaseFunc;
import org.example.Utility.JDBCProvider;
import org.example.Utility.MetadataProvider;

import java.sql.*;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {

        PersonDAOImpl personDAO = new PersonDAOImpl();

        //DATABASE OPERATIONS PART
        DatabaseFunc.recreateTable();
        PersonDTO person = PersonDTO.builder()
                .age(20)
                .address("TEST")
                .salary(1234.2)
                .passport("test")
                .dateTimeCreate(Timestamp.valueOf("2014-01-11 11:00:00"))
                .dateOfBirthday(Date.valueOf("2014-01-11"))
                .timeToLunch(Time.valueOf("11:00:00"))
                .build();
        personDAO.save(person);
        PersonDTO personDTO = personDAO.get(6);
        personDAO.delete(7);
        System.out.println(personDTO + "\n");
        personDTO.setAddress("NopeUpdate");
        personDAO.update(personDTO);
        List<PersonDTO> personDTOList = personDAO.selectAllByAge(40);
        personDTOList.forEach(System.out::println);


        //METADATA PART
        DatabaseMetaData metaData = DatabaseFunc.getConnection().getMetaData();
        MetadataProvider.getAllTables(metaData);
        String curTable = "people";
        MetadataProvider.getPrimaryKeys(metaData, curTable);
        MetadataProvider.getTableColumns(metaData, curTable);

        JDBCProvider.closeConnection();
    }


}
