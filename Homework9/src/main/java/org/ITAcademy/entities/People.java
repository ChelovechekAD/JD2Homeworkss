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
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "people_addresses",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private List<Address> addressList = new ArrayList<>();

    public void setAddresses(List<Address> addresses) {
        this.addressList = addresses;
    }

    public void addAddress(Address address) {
        addressList.add(address);
    }

    public void deleteAddress(Address address) {
        addressList.remove(address);
    }
}
