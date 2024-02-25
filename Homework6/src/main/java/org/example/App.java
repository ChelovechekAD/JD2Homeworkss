package org.example;


import org.example.DAO.HibernatePersonDAO;
import org.example.DAO.HibernatePersonDAOImpl;
import org.example.DTO.PersonDTO;
import org.example.Utility.HibernateUtil;

import java.sql.*;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.Utility.Constants.*;

public class App {

    public static void main(String[] args) {

        HibernatePersonDAO hibernatePersonDAO = new HibernatePersonDAOImpl();

        List<PersonDTO> inputList = generatePersonsList(COUNT_OF_PERSONS);
        List<PersonDTO> outputList = inputList.stream()
                .map(hibernatePersonDAO::save)
                .collect(Collectors.toList());

        List<PersonDTO> personDTOList = hibernatePersonDAO.
                findByColumn(AGE_COLUMN_NAME, AGE_TO_SELECT_FROM_DB, COLUMN_NAME_DATE_TIME_CREATE);
        personDTOList.forEach(System.out::println);

        shutdown();
    }

    private static List<PersonDTO> generatePersonsList(int count) {
        Random random = new Random();
        return IntStream.range(0, count)
                .mapToObj(i -> PersonDTO.builder()
                        .age(random.nextInt(20) + 10)
                        .address("Hibernate Save")
                        .salary(random.nextInt(100000) + 10000 + ((double) Math.round(random.nextFloat() * 100) / 100))
                        .passport("test")
                        .dateTimeCreate(Timestamp.valueOf("2014-01-11 11:00:00"))
                        .dateOfBirthday(Date.valueOf("2014-01-11"))
                        .timeToLunch(Time.valueOf("11:00:00"))
                        .build())
                .collect(Collectors.toList());
    }

    private static void shutdown() {
        HibernateUtil.close();
    }


}
