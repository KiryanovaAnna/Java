package com.epam.kiryanova_anna.java.lesson3.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Кирьянова Анна, 3 задание
public class EducationalCenter {
    private List<Student> students;

    public EducationalCenter(List<Student> students) {
        this.students = new ArrayList<>();
        this.students.addAll(students);
    }

    public List<Student> getAllStudents() {
        return this.students;
    }

    public static void main(String[] args) throws IOException {
        EducationalCenter ec = new EducationalCenter(
                Arrays.asList(new Student("Ivanov Ivan",
                                new Curriculum("J2EE Developer",
                                        LocalDateTime.of(2018, 5, 27, 14, 0),
                                        new ArrayList<>(Arrays.asList(
                                                new Course("Технология Java Servlets", 16),
                                                new Course("Struts Framework", 24))))),
                        new Student("Petrov Petr",
                                new Curriculum("Java Developer",
                                        LocalDateTime.of(2018, 5, 29, 10, 0),
                                        new ArrayList<>(Arrays.asList(
                                                new Course("Обзор технологий Java", 8),
                                                new Course("Библиотека JFC/Swing", 16),
                                                new Course("Технология JDBC", 16)))))));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String argums;
        if ((argums = br.readLine()).length() == 0 || argums.equals("0")) {
            for (Student student : ec.getAllStudents())
                System.out.println(student.report());
        }
        else {
            for (Student student : ec.getAllStudents())
                System.out.println(student.detailedReport());
        }
    }
}
