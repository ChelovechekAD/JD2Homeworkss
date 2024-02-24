package org.example.print;

import org.example.annotation.AcademyInfo;

public class Printer {

    public void printHelloWorld(Integer i, double j) {
        System.out.println(i + ", " + j);
    }

    @AcademyInfo(year = 2024)
    public void printHelloWorld(String text) {
        System.out.println(text);
    }
}