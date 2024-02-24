package org.ITAcademy.Utilities;


import org.ITAcademy.Models.Person;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonManager {
    public static List<Person> filterPersonsGroup(List<Person> personList, Predicate<Person> predicate) {
        return personList.stream()
                .filter(predicate)
                .peek(System.out::println)
                .sorted(Comparator.comparing(Person::getSurname)
                        .thenComparing(Person::getName))
                .distinct()
                .collect(Collectors.toList());
    }

}