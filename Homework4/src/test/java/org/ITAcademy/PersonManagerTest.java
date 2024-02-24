package org.ITAcademy;

import org.ITAcademy.Models.Person;
import org.ITAcademy.Utilities.PersonManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonManagerTest {
    private static final Person PERSON_1 = new Person("Артем", "Юшкевич", 20);
    private static final Person PERSON_2 = new Person("Антон", "Обычный", 9);
    private static final Person PERSON_3 = new Person("Артем", "Юшкевич", 20);
    private static final Person PERSON_4 = new Person("Джеймс", "Бонд", 42);
    private static final Person PERSON_5 = new Person("Марк", "Цукенберг", 40);
    private static final List<Person> personList = new ArrayList<>();

    @BeforeAll
    public static void createPersonList() {
        personList.add(PERSON_1);
        personList.add(PERSON_2);
        personList.add(PERSON_3);
        personList.add(PERSON_4);
        personList.add(PERSON_5);
    }

    @Test
    public void filterPersonsGroupTest() {
        final Predicate<Person> personUnder21 = p -> p.getAge() < 21;
        List<Person> expected = new ArrayList<>(List.of(PERSON_2, PERSON_1));
        List<Person> actual = PersonManager.filterPersonsGroup(personList, personUnder21);

        assertEquals(expected, actual);
    }
}