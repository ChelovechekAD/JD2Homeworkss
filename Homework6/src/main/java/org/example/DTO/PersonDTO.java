package org.example.DTO;


import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

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
}