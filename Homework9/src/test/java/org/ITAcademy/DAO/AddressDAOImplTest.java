package org.ITAcademy.DAO;

import org.ITAcademy.DAO.impl.AddressDAOImpl;
import org.ITAcademy.entities.Address;
import org.ITAcademy.utilities.MockConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.ITAcademy.utilites.Generators.generateObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressDAOImplTest {

    private final AddressDAO addressDAO = new AddressDAOImpl();
    private List<Address> addressList;

    @BeforeEach
    public void generateList() {
        addressList = IntStream.range(0, MockConstants.COUNT_OF_GENERATED_OBJECT)
                .mapToObj(i -> generateObject(Address.class))
                .collect(Collectors.toList());
    }

    @Test
    public void increaseTest() {
        addressList.forEach(addressDAO::create);
        List<Integer> listInt = addressList.stream()
                .map(a -> a.getHouseNum() + MockConstants.INCREMENT_HOUSE_NUM_ADDRESS_TEST)
                .collect(Collectors.toList());
        List<Address> addressListMod = addressList.stream()
                .map(a -> addressDAO.increaseHomeNum(a.getId(), MockConstants.INCREMENT_HOUSE_NUM_ADDRESS_TEST))
                .collect(Collectors.toList());

        IntStream.range(0, listInt.size())
                .forEach(i -> assertEquals(listInt.get(i), addressListMod.get(i).getHouseNum()));
    }


}
