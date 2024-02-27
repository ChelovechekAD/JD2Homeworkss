package org.ITAcademy;

import org.ITAcademy.DAO.AddressDAO;
import org.ITAcademy.DAO.PeopleDAO;
import org.ITAcademy.DAO.impl.AddressDAOImpl;
import org.ITAcademy.DAO.impl.PeopleDAOImpl;
import org.ITAcademy.entities.Address;
import org.ITAcademy.entities.People;
import org.ITAcademy.utilites.Constants;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.ITAcademy.utilites.Generators.generateObject;

public class Main {

    public static void main(String[] args) {

        AddressDAO addressDAO = new AddressDAOImpl();
        PeopleDAO peopleDAO = new PeopleDAOImpl();

        Random random = new Random();

        //Create #Task1
        List<People> peopleList = IntStream.range(0, Constants.COUNT_OF_OBJECT_EACH_TYPE)
                .mapToObj(i -> Objects.requireNonNull(generateObject(People.class)))
                .collect(Collectors.toList());

        List<Address> addressList = IntStream.range(0, Constants.COUNT_OF_OBJECT_EACH_TYPE)
                .mapToObj(i -> Objects.requireNonNull(generateObject(Address.class)))
                .collect(Collectors.toList());

        peopleList.forEach(people -> people.setAddress(addressList.get(random.nextInt(addressList.size()))));

        addressList.forEach(addressDAO::create);
        peopleList.forEach(peopleDAO::create);


        //Increase #Task2
        List<People> peopleListMod = peopleList.stream()
                .peek(System.out::println)
                .filter(p -> peopleList.indexOf(p) == peopleList.size() - 1
                        || peopleList.indexOf(p) == peopleList.size() - 2)
                .map(p -> peopleDAO.increaseAge(p.getId(), 2))
                .collect(Collectors.toList());
        System.out.println("\nChanged people objects:");
        peopleListMod.forEach(System.out::println);
        System.out.println();

        List<Address> addressListMod = addressList.stream()
                .peek(System.out::println)
                .filter(a -> addressList.indexOf(a) == addressList.size() - 1
                        || addressList.indexOf(a) == addressList.size() - 2)
                .map(a -> addressDAO.increaseHomeNum(a.getId(), 1))
                .collect(Collectors.toList());
        System.out.println("\nChanged address objects:");
        addressListMod.forEach(System.out::println);

        //Delete #Task3
        peopleDAO.delete(peopleList.get(0).getId());
        addressDAO.delete(addressList.get(0).getId());
    }
}