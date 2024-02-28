package org.ITAcademy.DAO;

import org.ITAcademy.DAO.impl.AddressDAOImpl;
import org.ITAcademy.DAO.impl.PeopleDAOImpl;
import org.ITAcademy.entities.Address;
import org.ITAcademy.utilites.HibernateUtil;
import org.ITAcademy.utilities.MockConstants;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.ITAcademy.utilites.Generators.*;
import static org.junit.jupiter.api.Assertions.*;

public class DAOImplTest {

    private final AddressDAO addressDAO = new AddressDAOImpl();
    private List<Address> addressList;

    @BeforeEach
    public void generateList() {
        addressList = IntStream.range(0, MockConstants.COUNT_OF_GENERATED_OBJECT)
                .mapToObj(i -> generateObject(Address.class))
                .collect(Collectors.toList());
    }

    @Test
    public void saveTest() {

        addressList.forEach(addressDAO::create);

        List<Address> savedAddressList = addressList.stream()
                .peek(a -> addressDAO.read(a.getId()))
                .collect(Collectors.toList());

        assertIterableEquals(addressList, savedAddressList);
    }

    @Test
    public void updateTest() {
        addressList.forEach(addressDAO::create);
        List<String> excepted = addressList.stream()
                .map(a -> a.getStreet() + MockConstants.STRING_TEXT_UPDATE_TEST)
                .collect(Collectors.toList());

        addressList.forEach(a -> a.setStreet(a.getStreet() + MockConstants.STRING_TEXT_UPDATE_TEST));
        addressList.forEach(addressDAO::update);

        IntStream.range(0, excepted.size())
                .forEach(i -> assertEquals(excepted.get(i), addressList.get(i).getStreet()));
    }

    @Test
    public void deleteTest() {
        addressList.forEach(addressDAO::create);

        addressList.forEach(a -> addressDAO.delete(a.getId()));

        List<Address> actual = addressList.stream()
                .map(a -> addressDAO.read(a.getId()))
                .collect(Collectors.toList());

        IntStream.range(0, actual.size())
                .forEach(i -> assertNull(actual.get(i)));
    }

}
