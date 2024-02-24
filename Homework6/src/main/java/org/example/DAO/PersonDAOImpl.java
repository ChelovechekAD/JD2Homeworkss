package org.example.DAO;

import org.example.DTO.PersonDTO;
import org.example.TemplateSql.InsertTemplates;
import org.example.TemplateSql.Statements;
import org.example.Utility.JDBCProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private final Connection connection = JDBCProvider.getConnection();

    @Override
    public PersonDTO save(PersonDTO person) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(Statements.INSERT_PEOPLE_PREPARE_STATEMENT)) {
            InsertTemplates.insertPeople(ps, person);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }
        return person;
    }

    @Override
    public void update(PersonDTO person) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(Statements.UPDATE_PEOPLE_PREPARE_STATEMENT)) {
            InsertTemplates.updatePeople(ps, person, person.getId());
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }
    }

    @Override
    public PersonDTO get(int id) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(Statements.SELECT_PEOPLE_PREPARE_STATEMENT);
        try (ResultSet resultSet = InsertTemplates.selectPeople(ps, id);) {
            return resultSet.next() ? buildPersonDTO(resultSet) : null;
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(Statements.DELETE_PEOPLE_PREPARE_STATEMENT)) {
            InsertTemplates.deletePeople(ps, id);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }
    }

    @Override
    public List<PersonDTO> selectAllByAge(int age) {
        List<PersonDTO> personDTOList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM jd2lessons.people WHERE age>=" + age + " ORDER BY dateTimeCreate");
            while (resultSet.next()) {
                personDTOList.add(PersonDTO.builder()
                        .age(resultSet.getInt(2))
                        .salary(resultSet.getDouble(3))
                        .passport(resultSet.getString(4))
                        .address(resultSet.getString(5))
                        .dateOfBirthday(resultSet.getDate(6))
                        .dateTimeCreate(resultSet.getTimestamp(7))
                        .timeToLunch(resultSet.getTime(8))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return personDTOList;
    }

    private PersonDTO buildPersonDTO(ResultSet resultSet) throws SQLException {
        return PersonDTO.builder()
                .id(resultSet.getInt(1))
                .age(resultSet.getInt(2))
                .salary(resultSet.getDouble(3))
                .passport(resultSet.getString(4))
                .address(resultSet.getString(5))
                .dateOfBirthday(resultSet.getDate(6))
                .dateTimeCreate(resultSet.getTimestamp(7))
                .timeToLunch(resultSet.getTime(8))
                .build();
    }
}
