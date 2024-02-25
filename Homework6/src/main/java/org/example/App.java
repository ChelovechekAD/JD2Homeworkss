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

        PersonDAO personDAO = new PersonDAOImpl();

        //DATABASE OPERATIONS PART
        DatabaseFunc.recreateTable();

        List<PersonDTO> inputList = PersonDTO.generatePersonsList(5);
        inputList.stream()
                .map(p -> {
                    try {
                        return personDAO.save(p);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(System.out::println);
        PersonDTO personDTO = personDAO.get(4);
        System.out.println(personDTO + "\n");
        personDTO.setAddress("NopeUpdate");
        personDAO.update(personDTO);
        System.out.println("___AGE_UPPER_21___");
        List<PersonDTO> personDTOList = personDAO.selectAllByAge(21);
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
