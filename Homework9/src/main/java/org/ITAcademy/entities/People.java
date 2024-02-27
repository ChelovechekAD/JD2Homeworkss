package org.ITAcademy.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
@ToString
@Table(name = "people")
public class People implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Integer age;
}
