package org.ITAcademy;


import org.ITAcademy.Models.Person;

import java.util.List;
import java.util.function.Predicate;

public class Constants {
    public static final int GROUP_SIZE = 100;
    public static final int MIN_AGE = 15;
    public static final int MAX_AGE = 30;
    public static final Predicate<Person> PERSON_UNDER_21 = p -> p.getAge() < 21;
    public static final String FILE_PATH = "Homework4\\src\\main\\resources\\Persons.txt";

    public final static List<String> NAMES = List.of("Артем", "Елена", "Ольга", "Дмитрий", "Тимофей", "Никита", "Антон");
    public final static List<String> SURNAMES = List.of("Костылев(а)", "Кулаков(а)", "Пропилен",
            "Костевич", "Рублевский(ая)", "Жогло", "Мазаник");
    public final static Integer COUNT_OF_NAMES = NAMES.size();
    public final static Integer COUNT_OF_SURNAMES = SURNAMES.size();
}