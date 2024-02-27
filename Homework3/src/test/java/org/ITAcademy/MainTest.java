package org.ITAcademy;

import org.ITAcademy.Utilities.PrinterTemplatesGenerator;
import org.ITAcademy.models.Skill;
import org.ITAcademy.models.Student;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @ParameterizedTest
    @MethodSource("testStudentType1Cases")
    public void testStudentType1(double timeToStudy, String studentName, double talentValue, double timeForOneAction) {
        Skill skill = new Skill("java core", 22);
        Student student = new Student(studentName, Constants.TYPE1);
        student.setTalentValue(talentValue);
        StringBuilder expected = new StringBuilder(studentName + ", Тип " + student.getType() + ", талант: " + String.format("%.1f", talentValue)
                + ", общее время на обучение: " + String.format("%.1f", timeToStudy) + ": ");
        for (int i = 0; i < 4 - student.getType(); i++) {
            expected.append(PrinterTemplatesGenerator.generateTemplateForStudyOutput(i, timeForOneAction));
        }
        StringBuilder actual = student.studentLearnNewSkill(skill);
        assertEquals(expected.toString(), actual.toString());
    }

    @ParameterizedTest
    @MethodSource("testStudentType2Cases")
    public void testStudentType2(double timeToStudy, String studentName, double talentValue, double timeForOneAction) {
        Skill skill = new Skill("java core", 22);
        Student student = new Student(studentName, Constants.TYPE2);
        student.setTalentValue(talentValue);
        StringBuilder expected = new StringBuilder(studentName + ", Тип " + student.getType() + ", талант: " + String.format("%.1f", talentValue)
                + ", общее время на обучение: " + String.format("%.1f", timeToStudy) + ": ");
        for (int i = 0; i < 4 - student.getType(); i++) {
            expected.append(PrinterTemplatesGenerator.generateTemplateForStudyOutput(i, timeForOneAction));
        }
        StringBuilder actual = student.studentLearnNewSkill(skill);
        assertEquals(expected.toString(), actual.toString());
    }

    @ParameterizedTest
    @MethodSource("testStudentType3Cases")
    public void testStudentType3(double timeToStudy, String studentName, double talentValue, double timeForOneAction) {
        Skill skill = new Skill("java core", 22);
        Student student = new Student(studentName, Constants.TYPE3);
        student.setTalentValue(talentValue);
        StringBuilder expected = new StringBuilder(studentName + ", Тип " + student.getType() + ", талант: " + String.format("%.1f", talentValue)
                + ", общее время на обучение: " + String.format("%.1f", timeToStudy) + ": ");
        for (int i = 0; i < 4 - student.getType(); i++) {
            expected.append(PrinterTemplatesGenerator.generateTemplateForStudyOutput(i, timeForOneAction));
        }
        StringBuilder actual = student.studentLearnNewSkill(skill);
        assertEquals(expected.toString(), actual.toString());
    }

    static Stream<Arguments> testStudentType1Cases() {
        return Stream.of(
                Arguments.of(22.0, "Student", 1.0, 7.3),
                Arguments.of(220.0, "Student", 0.1, 73.3),
                Arguments.of(44.0, "Student", 0.5, 14.7),
                Arguments.of(27.5, "Student", 0.8, 9.2)
        );
    }

    static Stream<Arguments> testStudentType2Cases() {
        return Stream.of(
                Arguments.of(44.0, "Student", 1.0, 22),
                Arguments.of(440.0, "Student", 0.1, 220),
                Arguments.of(88.0, "Student", 0.5, 44),
                Arguments.of(55, "Student", 0.8, 27.5)
        );
    }

    static Stream<Arguments> testStudentType3Cases() {
        return Stream.of(
                Arguments.of(66.0, "Student", 1.0, 66),
                Arguments.of(660.0, "Student", 0.1, 660),
                Arguments.of(132.0, "Student", 0.5, 132),
                Arguments.of(82.5, "Student", 0.8, 82.5)
        );
    }

}