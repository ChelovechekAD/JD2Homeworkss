package org.ITAcademy.DAO;

import org.ITAcademy.DAO.impl.AddressDAOImpl;
import org.ITAcademy.DAO.impl.PeopleDAOImpl;
import org.ITAcademy.entities.Address;
import org.ITAcademy.entities.People;
import org.ITAcademy.utilities.MockConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.ITAcademy.utilites.Generators.generateObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeopleDAOImplTest {
    private final PeopleDAO peopleDAO = new PeopleDAOImpl();
    private List<People> peopleList;

    @BeforeEach
    public void generateList() {
        peopleList = IntStream.range(0, MockConstants.COUNT_OF_GENERATED_OBJECT)
                .mapToObj(i -> generateObject(People.class))
                .collect(Collectors.toList());
    }

    @Test
    public void increaseTest() {
        peopleList.forEach(peopleDAO::create);
        List<Integer> listInt = peopleList.stream()
                .map(a -> a.getAge() + MockConstants.INCREMENT_HOUSE_NUM_ADDRESS_TEST)
                .collect(Collectors.toList());
        List<People> addressListMod = peopleList.stream()
                .map(a -> peopleDAO.increaseAge(a.getId(), MockConstants.INCREMENT_HOUSE_NUM_ADDRESS_TEST))
                .collect(Collectors.toList());

        IntStream.range(0, listInt.size())
                .forEach(i -> assertEquals(listInt.get(i), addressListMod.get(i).getAge()));
    }
}
