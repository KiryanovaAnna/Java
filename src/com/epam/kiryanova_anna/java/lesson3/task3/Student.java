package com.epam.kiryanova_anna.java.lesson3.task3;

import java.time.LocalDateTime;

public class Student {
    private String name;
    private Curriculum curriculum;

    public Student(String name, Curriculum curriculum) {
        this.name = name;
        this.curriculum = curriculum;
    }

    public String ifCompleted() {
        String result;

        int[] diff = curriculum.getTimeDifference(LocalDateTime.now());
        if (diff[0] == -1)
            result = "Обучение не закончено. До окончания осталось ";
        else result = "Обучение закончено. После окончания прошло ";

        if (diff[1] != 0)
            result += diff[1] + " д ";
        result += diff[2] + " ч.\n";

        return result;
    }

    public String report() {
        return name + " (" + curriculum.getName() + ") - " + ifCompleted();
    }

    public String detailedReport() {
        String result = name;

        result += "\nWorking hours: 10:00 to 18:00";
        result += "\nCurriculum: " + curriculum.getName();
        result += "\nCurriculum length: " + curriculum.getCoursesLength() + " hours";
        result += "\nStart date: " + curriculum.getStartDate();
        result += "\nEnd date: " + curriculum.getEndDate();
        result += "\n" + ifCompleted();

        return result;
    }
}
