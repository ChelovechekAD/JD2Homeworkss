package org.example.man;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;


public class ManDemo {
    public static void main(String[] args) {
        Man man = new Man("Chelovek", 199, 20);
        ClassIfoPrinter.printClassInfo(Man.class);
        System.out.println(man);
    }

}