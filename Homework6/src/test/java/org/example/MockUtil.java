package org.example;

import org.example.DTO.PersonDTO;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockUtil {

    private MockUtil(){

    }
    public static List<PersonDTO> createListPersons(int count){
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

}
