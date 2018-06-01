package com.epam.kiryanova_anna.java.lesson3.task3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Curriculum {
    private String name;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<Course> courses;

    public Curriculum(String name, LocalDateTime startDate, List<Course> courses) {
        this.name = name;

        this.startDate = startDate;

        this.courses = new ArrayList<>();
        this.courses.addAll(courses);

        int length = 0;
        for (Course course : courses)
            length += course.getCourseLength();

        int days = length / 8;
        int hours = length % 8;

        this.endDate = startDate.plusDays(days).plusHours(hours);

        if (this.endDate.getHour() > 18) {
            this.endDate = this.endDate.plusDays(1);
            this.endDate = this.endDate.withHour(this.endDate.getHour() - 18 + 10);
        }

        if (this.endDate.getHour() == 10)
            this.endDate = this.endDate.minusDays(1).withHour(18);
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getCoursesLength() {
        int coursesLength = 0;
        for (Course course : courses)
            coursesLength += course.getCourseLength();

        return coursesLength;
    }

    public int[] getTimeDifference(LocalDateTime now) {
        int[] diff = new int[3];
        int days;
        int hours;

        if (now.isBefore(this.endDate)) {
            diff[0] = -1;

            if (now.getHour() < 10)
                now = now.withHour(10).withMinute(0).withSecond(0).withNano(0);
            if (now.getHour() >= 18)
                now = now.withHour(10).withMinute(0).withSecond(0).withNano(0).plusDays(1);

            days = (int) Duration.between(now, endDate).toDays();
            hours = endDate.getHour() - now.getHour();
        } else {
            diff[0] = 1;

            if (now.getHour() <= 10)
                now = now.withHour(18).withMinute(0).withSecond(0).withNano(0).minusDays(1);
            if (now.getHour() > 18)
                now = now.withHour(18).withMinute(0).withSecond(0).withNano(0);

            days = (int) Duration.between(endDate, now).toDays();
            hours = now.getHour() - endDate.getHour();
        }

        diff[1] = days;
        diff[2] = hours;

        return diff;
    }
}