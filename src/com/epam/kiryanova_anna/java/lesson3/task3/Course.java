package com.epam.kiryanova_anna.java.lesson3.task3;

public class Course {
    private String name;
    private int length;

    public Course(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getCourseName() {
        return name;
    }

    public int getCourseLength() {
        return length;
    }
}
