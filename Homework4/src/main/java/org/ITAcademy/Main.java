package org.ITAcademy;

import org.ITAcademy.Models.Person;
import org.ITAcademy.Utilities.FileManager;
import org.ITAcademy.Utilities.PersonGenerator;
import org.ITAcademy.Utilities.PersonManager;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.ITAcademy.Constants.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new File(FILE_PATH).createNewFile();
        List<Person> personList = new PersonGenerator().generatePersonsGroup(GROUP_SIZE);
        personList = PersonManager.filterPersonsGroup(personList, PERSON_UNDER_21);

        System.out.println("\nSTART WRITING...\n");
        FileManager.writeObjects(personList, FILE_PATH);

        System.out.println("\nSTART READING...\n");
        List<String> persons = FileManager.readObjects(FILE_PATH).stream()
                .map(p -> ((Person) p).getSurname() + " " + ((Person) p).getName())
                .collect(Collectors.toList());

        persons.forEach(System.out::println);
    }
}