package org.ITAcademy;

import org.ITAcademy.models.Skill;
import org.ITAcademy.models.Student;

import java.util.ArrayList;
import java.util.List;

import static org.ITAcademy.Constants.*;


public class Main {
    private int studentCounter;

    public static void main(String[] args) {
        Main app = new Main();
        Skill skill = new Skill(SKILL_NAME, DURATION_OF_SKILL_LEARNING);
        List<Student> students = new ArrayList<>();
        students.addAll(app.generateStudents(COUNT_OF_STUDENTS_TYPE_1, TYPE1));
        students.addAll(app.generateStudents(COUNT_OF_STUDENTS_TYPE_2, TYPE2));
        students.addAll(app.generateStudents(COUNT_OF_STUDENTS_TYPE_3, TYPE3));
        students.forEach(student -> System.out.println(student.studentLearnNewSkill(skill)));
    }

    public List<Student> generateStudents(int numberOfStudents, int type) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            students.add(new Student(STUDENT_NUMBER + ++studentCounter, type));
        }
        return students;
    }
}