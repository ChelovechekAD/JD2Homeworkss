package org.example.TemplateSql;

import org.example.DTO.PersonDTO;

import java.sql.*;

public class InsertTemplates {

    public static void insertPeople(
            PreparedStatement pS, PersonDTO personDTO) throws SQLException {
        allArgsFragment(pS, personDTO);
        pS.executeUpdate();
    }

    public static ResultSet selectPeople(PreparedStatement preparedStatement, Integer id) throws SQLException {
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

    public static void updatePeople(PreparedStatement pS, PersonDTO personDTO, Integer id) throws SQLException {
        allArgsFragment(pS, personDTO);
        pS.setInt(8, id);
        pS.executeUpdate();
    }

    public static void deletePeople(PreparedStatement preparedStatement, Integer id) throws SQLException {
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    private static void allArgsFragment(PreparedStatement pS, PersonDTO personDTO) throws SQLException {
        pS.setInt(1, personDTO.getAge());
        pS.setDouble(2, personDTO.getSalary());
        pS.setString(3, personDTO.getPassport());
        pS.setString(4, personDTO.getAddress());
        pS.setDate(5, personDTO.getDateOfBirthday());
        pS.setTimestamp(6, personDTO.getDateTimeCreate());
        pS.setTime(7, personDTO.getTimeToLunch());
    }

}
