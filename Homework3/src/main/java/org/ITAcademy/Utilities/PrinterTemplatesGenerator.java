package org.ITAcademy.Utilities;

public class PrinterTemplatesGenerator {

    public static String generateTemplateForStudyOutput(int i, double durationOfStudyOneSection) {
        switch (i+1){
            case 1: return "\n время для практики: " + String.format("%.1f", durationOfStudyOneSection);
            case 2: return "\n время для разбора: " + String.format("%.1f", durationOfStudyOneSection);
            case 3: return "\n время для нахождения в потоке: " + String.format("%.1f", durationOfStudyOneSection);
            default: return "";
        }
    }
}
