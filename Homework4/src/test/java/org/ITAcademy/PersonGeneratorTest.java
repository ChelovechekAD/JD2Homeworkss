package org.ITAcademy;

import org.ITAcademy.Models.Person;
import org.ITAcademy.Utilities.PersonGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonGeneratorTest {
    @ParameterizedTest
    @MethodSource("personsGroupCases")
    public void generatePersonsGroupTest(int groupSize) {
        List<Person> actual = new PersonGenerator().generatePersonsGroup(groupSize);
        assertEquals(groupSize, actual.size());
    }

    static Stream<Arguments> personsGroupCases() {
        return Stream.of(
                Arguments.of(100),
                Arguments.of(10),
                Arguments.of(25),
                Arguments.of(80),
                Arguments.of(79)
        );
    }

}