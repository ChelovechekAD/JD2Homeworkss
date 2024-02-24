package org.ITAcademy.models;

import org.ITAcademy.Utilities.PrinterTemplatesGenerator;

import static org.ITAcademy.Constants.*;

public class Student {
    private String name;
    private double talentValue = Math.round((Math.random() + 0.1) * 10) * 0.1;
    private int type;
    private int studyTimeMultiplier;


    public Student(String name, int type) {
        this.name = name;
        this.type = type;
        switch (type) {
            case 1:
                studyTimeMultiplier = DURATION_OF_STUDY_MULTIPLIER_TYPE1;
                break;
            case 2:
                studyTimeMultiplier = DURATION_OF_STUDY_MULTIPLIER_TYPE2;
                break;
            case 3:
                studyTimeMultiplier = DURATION_OF_STUDY_MULTIPLIER_TYPE3;
                break;
            default:
                studyTimeMultiplier = 0;
        }
    }


    public StringBuilder studentLearnNewSkill(Skill skill) {
        int countOfActions = 4 - type;
        double durationOfStudy = Math.round(skill.getTimeToStudy()
                * this.studyTimeMultiplier
                / this.talentValue * 10) * 0.1;
        double durationOfStudyOnePart = Math.round((durationOfStudy / countOfActions) * 10) * 0.1;

        StringBuilder output = new StringBuilder(this.name
                + ", Тип " + this.type
                + ", талант: " + String.format("%.1f", this.talentValue)
                + ", общее время на обучение: " + String.format("%.1f", durationOfStudy) + ": ");
        for (int i = 0; i < countOfActions; i++) {
            output.append(PrinterTemplatesGenerator.generateTemplateForStudyOutput(i, durationOfStudyOnePart));
        }

        return output;
    }

    public String getName() {
        return name;
    }

    public double getTalentValue() {
        return talentValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTalentValue(double talentValue) {
        this.talentValue = talentValue;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStudyTimeMultiplier() {
        return studyTimeMultiplier;
    }

    public void setStudyTimeMultiplier(int studyTimeMultiplier) {
        this.studyTimeMultiplier = studyTimeMultiplier;
    }

    public int getType() {
        return type;
    }
}