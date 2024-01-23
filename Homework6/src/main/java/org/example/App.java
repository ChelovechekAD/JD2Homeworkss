package org.example;


import org.example.Utility.JDBCProvider;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static final Connection connection = JDBCProvider.getConnection();
    private static final Statement statement;

    private static final String INSERT_PEOPLE_STATEMENT = "INSERT INTO homework6.people (age, salary, passport, address," +
            " \"dateOfBirthday\", \"dateTimeCreate\", \"timeToLunch\") " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {

        //DATABASE OPERATIONS PART
        recreateTable();
        insertPart();
        selectOnAge(21);
        DatabaseMetaData metaData = connection.getMetaData();


        //METADATA PART
        getAllTables(metaData);
        String curTable = "people";
        getPrimaryKeys(metaData, curTable);
        getTableColumns(metaData, curTable);


    }

    private static void getPrimaryKeys(DatabaseMetaData metaData, String curTable) throws SQLException {
        ResultSet rs = metaData.getPrimaryKeys(null, null, curTable);
        System.out.println("\n_____PRIMARY_KEYS_____");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | "
                    + rs.getString(3) + " | " + rs.getString(4) + " | "
                    + rs.getString(5) + " | " + rs.getString(6));
        }
    }

    private static List<String> getAllTables(DatabaseMetaData metaData) throws SQLException {
        List<String> tables = new ArrayList<>();
        ResultSet rs = metaData.getTables(null, "homework6", null, new String[]{"TABLE"});
        while (rs.next()) {
            System.out.println("\n______TABLES______");
            System.out.println(rs.getString("TABLE_NAME"));
            tables.add(rs.getString("TABLE_NAME"));
        }
        return tables;
    }

    private static void getTableColumns(DatabaseMetaData metaData, String curTable) throws SQLException {
        System.out.println("\n______COLUMN_METADATA_______");
        ResultSet rs = metaData.getColumns(null, null, curTable, null);
        while (rs.next()) {
            System.out.println(rs.getString("COLUMN_NAME") + " "
                    + rs.getString("TYPE_NAME"));
        }
    }

    private static void insertPart() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PEOPLE_STATEMENT)) {

            connection.setAutoCommit(false);

            try {
                insertPeople(23, 32.2f, "sadad", "dasafsa", Date.valueOf("2024-01-10"),
                        Timestamp.valueOf("2024-01-22 23:42:43.000000"), Time.valueOf("23:47:20"), preparedStatement);
                insertPeople(18, 32.1f, "sadadad", "dasafsadd", Date.valueOf("2024-01-10"),
                        Timestamp.valueOf("2024-01-22 23:42:43.000000"), Time.valueOf("23:10:20"), preparedStatement);
                insertPeople(10, 132.2f, "Nope", "Nope", Date.valueOf("2023-10-10"),
                        Timestamp.valueOf("2024-01-22 23:42:43.000000"), Time.valueOf("23:47:20"), preparedStatement);
                insertPeople(40, 3.2f, "sadad", "dasafsa", Date.valueOf("2024-01-10"),
                        Timestamp.valueOf("2024-01-22 23:42:43.000000"), Time.valueOf("23:47:20"), preparedStatement);
                insertPeople(55, 320.2f, "sadad", "dasafsa", Date.valueOf("2024-01-10"),
                        Timestamp.valueOf("2024-01-22 23:42:41.000000"), Time.valueOf("23:47:20"), preparedStatement);
                preparedStatement.executeBatch();
                connection.commit();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                connection.rollback();
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private static void selectOnAge(Integer age) throws SQLException {
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM jd2lessons.homework6.people WHERE age>=" + age + " ORDER BY \"dateTimeCreate\"");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2) + " | " + resultSet.getString(3)
                    + " | " + resultSet.getString(4) + " | " + resultSet.getString(5)
                    + " | " + resultSet.getString(6) + " | " + resultSet.getString(7)
                    + " | " + resultSet.getString(8));
        }
    }

    private static void insertPeople(Integer age, Float salary, String passport, String address, Date dateOfBirthday,
                                     Timestamp dateTimeCreate, Time timeToLunch, PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement.setInt(1, age);
        preparedStatement.setFloat(2, salary);
        preparedStatement.setString(3, passport);
        preparedStatement.setString(4, address);
        preparedStatement.setDate(5, dateOfBirthday);
        preparedStatement.setTimestamp(6, dateTimeCreate);
        preparedStatement.setTime(7, timeToLunch);
        preparedStatement.addBatch();
    }

    private static void recreateTable() throws SQLException {
        connection.setAutoCommit(false);
        try {
            statement.executeUpdate("DROP TABLE IF EXISTS homework6.people");
            statement.executeUpdate("CREATE TABLE homework6.people\n" +
                    "(id                 integer generated always as identity\n" +
                    "        constraint people_pk\n" +
                    "            primary key,\n" +
                    "    age              integer      not null,\n" +
                    "    salary           float4       not null,\n" +
                    "    passport         varchar(10)  not null,\n" +
                    "    address          varchar(200) not null,\n" +
                    "    \"dateOfBirthday\" date       not null,\n" +
                    "    \"dateTimeCreate\" timestamp  not null,\n" +
                    "    \"timeToLunch\"    time       not null\n" +
                    ");");

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }
    }
}
