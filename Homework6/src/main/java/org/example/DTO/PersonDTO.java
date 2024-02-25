package org.example.DTO;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "people")
public class PersonDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private int age;
    @Column
    private double salary;
    @Column
    private String passport;
    @Column
    private String address;
    @Column(name = "date_of_birthday")
    private Date dateOfBirthday;
    @Column(name = "date_time_create")
    @CreationTimestamp
    private Timestamp dateTimeCreate;
    @Column(name = "time_to_lunch")
    private Time timeToLunch;
}