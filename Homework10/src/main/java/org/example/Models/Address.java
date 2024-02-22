package org.example.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Access(AccessType.PROPERTY)
public class Address {

    @Column
    private String street;
    @Column
    private String city;

}
