package org.ITAcademy.Utilities;


import org.ITAcademy.Models.Person;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.ITAcademy.Constants.*;

public class PersonGenerator {


    public List<Person> generatePersonsGroup(int groupSize) {
        return Stream.generate(this::generatePerson)
                .limit(groupSize)
                .collect(Collectors.toList());
    }

    private Person generatePerson() {
        String randomName = NAMES.get(new Random().nextInt(COUNT_OF_NAMES));
        String randomSurname = SURNAMES.get(new Random().nextInt(COUNT_OF_SURNAMES));
        int randomAge = new Random().nextInt(MAX_AGE - MIN_AGE) + MIN_AGE;
        return new Person(randomName, randomSurname, randomAge);
    }
}