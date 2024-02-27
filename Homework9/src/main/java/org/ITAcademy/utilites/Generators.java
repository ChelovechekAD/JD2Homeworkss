package org.ITAcademy.utilites;

import org.ITAcademy.entities.Address;
import org.ITAcademy.entities.People;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.ITAcademy.utilites.Constants.*;

public final class Generators {

    private static final Random RANDOM = new Random();

    private Generators() {

    }

    @SuppressWarnings("unchecked")
    public static <T> T generateObject(Class<T> tClass) {
        if (tClass == People.class) {
            return (T) generatePeople();
        } else if (tClass == Address.class) {
            return (T) generateAddress();
        }
        return null;
    }

    public static <T> List<?> generateListOfObjects(Class<T> tClass, int count) {
        if (tClass == People.class) {
            return generatorList(count, Generators::generatePeople);
        } else if (tClass == Address.class) {
            return generatorList(count, Generators::generateAddress);
        }
        return null;
    }


    private static List<?> generatorList(int count, Supplier<?> supplier) {
        return IntStream.range(0, count)
                .mapToObj(i -> supplier.get())
                .collect(Collectors.toList());
    }


    private static People generatePeople() {
        return People.builder()
                .age(RANDOM.nextInt(PEOPLE_AGE_MAX_BOUND - PEOPLE_AGE_MIN_BOUND) + PEOPLE_AGE_MIN_BOUND)
                .name(LIST_OF_NAMES[RANDOM.nextInt(COUNT_OF_NAMES)])
                .surname(LIST_OF_SURNAMES[RANDOM.nextInt(COUNT_OF_SURNAMES)])
                .addressList(new ArrayList<>())
                .build();
    }

    private static Address generateAddress() {
        return Address.builder()
                .street(LIST_OF_STREETS_NAME[RANDOM.nextInt(COUNT_OF_STREETS_NAME)])
                .houseNum(RANDOM.nextInt(ADDRESS_HOUSE_NUM_MAX_BOUND - ADDRESS_HOUSE_NUM_MIN_BOUND)
                        + ADDRESS_HOUSE_NUM_MIN_BOUND)
                .peopleList(new ArrayList<>())
                .build();
    }


}
