package org.ITAcademy.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "peopleList")
@ToString(exclude = "peopleList")
@Builder
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;
    @Column
    private String street;
    @Column(name = "house_num")
    private Integer houseNum;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "addressList")
    private List<People> peopleList = new ArrayList<>();

    public void setPeoples(List<People> peoples) {
        this.peopleList = peoples;
    }

    public void addPeople(People people) {
        peopleList.add(people);
    }

    public void deletePerson(People people) {
        peopleList.remove(people);
    }
}
