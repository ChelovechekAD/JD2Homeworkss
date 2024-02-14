package org.example.TemplateSql;

public interface Statements {

    public static final String INSERT_PEOPLE_PREPARE_STATEMENT = "insert into " +
            "jd2lessons.homework6.people(age, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch) " +
            "values (?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_PEOPLE_PREPARE_STATEMENT = "select * from jd2lessons.homework6.people where (id = ?)";
    public static final String UPDATE_PEOPLE_PREPARE_STATEMENT = "update jd2lessons.homework6.people " +
            "set (age = ?, salary = ?, passport = ?, address = ?, dateOfBirthday = ?, dateTimeCreate = ?, timeToLunch = ?) " +
            "where (id = ?)";
    public static final String DELETE_PEOPLE_PREPARE_STATEMENT = "delete from jd2lessons.homework6.people where (id = ?)";

}
