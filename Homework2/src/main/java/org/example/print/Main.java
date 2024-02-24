package org.example.print;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class Main {
    public static void main(String[] args) {
        try {
            Printer printer = new Printer();
            Method m4 = Printer.class.getMethod("printHelloWorld", Integer.class, double.class);
            m4.invoke(printer, 2, 6.5);
            Method m5 = Printer.class.getMethod("printHelloWorld", String.class);
            m5.invoke(printer, "asd");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}