package org.example.DTO;


import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class PersonDTO {
    private int id;
    private int age;
    private double salary;
    private String passport;
    private String address;
    private Date dateOfBirthday;
    private Timestamp dateTimeCreate;
    private Time timeToLunch;

    public static List<PersonDTO> generatePersonsList(int count) {
        Random random = new Random();
        return IntStream.range(0, count)
                .mapToObj(i -> PersonDTO.builder()
                        .age(random.nextInt(20) + 10)
                        .address("JDBC SAVE")
                        .salary(random.nextInt(100000) + 10000 + ((double) Math.round(random.nextFloat() * 100) / 100))
                        .passport("test")
                        .dateTimeCreate(Timestamp.valueOf("2014-01-11 11:00:00"))
                        .dateOfBirthday(Date.valueOf("2014-01-11"))
                        .timeToLunch(Time.valueOf("11:00:00"))
                        .build())
                .collect(Collectors.toList());
    }
}