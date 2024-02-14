package org.example.TemplateSql;

import java.sql.*;

public class InsertTemplates {

    public static void insertPeople(
            PreparedStatement pS, Integer age, Float salary,
            String passport, String address, Date dateOfBirthday,
            Timestamp dateTimeCreate, Time timeToLunch) throws SQLException {
        allArgsFragment(pS, age, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch);
        pS.addBatch();
    }

    public static ResultSet selectPeople(PreparedStatement preparedStatement, Integer id) throws SQLException {
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

    public static void updatePeople(PreparedStatement pS, Integer age, Float salary,
                                    String passport, String address, Date dateOfBirthday,
                                    Timestamp dateTimeCreate, Time timeToLunch, Integer id) throws SQLException {
        allArgsFragment(pS, age, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch);
        pS.setInt(8, id);
        pS.addBatch();
    }

    public static void deletePeople(PreparedStatement preparedStatement, Integer id) throws SQLException {
        preparedStatement.setInt(1, id);
        preparedStatement.addBatch();
    }

    private static void allArgsFragment(PreparedStatement pS, Integer age, Float salary,
                                        String passport, String address, Date dateOfBirthday,
                                        Timestamp dateTimeCreate, Time timeToLunch) throws SQLException {
        pS.setInt(1, age);
        pS.setDouble(2, salary);
        pS.setString(3, passport);
        pS.setString(4, address);
        pS.setDate(5, dateOfBirthday);
        pS.setTimestamp(6, dateTimeCreate);
        pS.setTime(7, timeToLunch);
    }

}
