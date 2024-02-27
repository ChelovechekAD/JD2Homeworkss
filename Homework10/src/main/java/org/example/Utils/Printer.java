package org.example.Utils;

import java.util.List;
import java.util.Set;

public class Printer {
    public static void print(String textTopSide, Object obj) {
        System.out.println("\n" + textTopSide);
        if (obj instanceof Iterable) {
            if (obj instanceof List) {
                List<?> list = (List<?>) obj;
                list.forEach(System.out::println);
            } else if (obj instanceof Set) {
                Set<?> set = (Set<?>) obj;
                set.forEach(System.out::println);
            } else {
                for (var elem : (Iterable<?>) obj) {
                    System.out.println(elem);
                }
            }
        } else if (obj instanceof Object[]) {
            for (var elem : (Object[]) obj) {
                System.out.println(elem);
            }

        } else {
            System.out.println(obj);
        }
        System.out.println("|END|\n");
    }

}
