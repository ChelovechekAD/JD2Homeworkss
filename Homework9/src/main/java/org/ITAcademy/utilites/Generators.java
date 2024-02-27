package org.ITAcademy.utilites;

import org.ITAcademy.entities.Address;
import org.ITAcademy.entities.People;

import java.util.Random;

import static org.ITAcademy.utilites.Constants.*;

public final class Generators {

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

    private static People generatePeople() {
        return People.builder()
                .age(RANDOM.nextInt(PEOPLE_AGE_MAX_BOUND - PEOPLE_AGE_MIN_BOUND) + PEOPLE_AGE_MIN_BOUND)
                .name(LIST_OF_NAMES[RANDOM.nextInt(COUNT_OF_NAMES)])
                .surname(LIST_OF_SURNAMES[RANDOM.nextInt(COUNT_OF_SURNAMES)])
                .build();
    }

    private static Address generateAddress() {
        return Address.builder()
                .street(LIST_OF_STREETS_NAME[RANDOM.nextInt(COUNT_OF_STREETS_NAME)])
                .houseNum(RANDOM.nextInt(ADDRESS_HOUSE_NUM_MAX_BOUND - ADDRESS_HOUSE_NUM_MIN_BOUND)
                        + ADDRESS_HOUSE_NUM_MIN_BOUND)
                .build();
    }

}
