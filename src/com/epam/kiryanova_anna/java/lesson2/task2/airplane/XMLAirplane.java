package com.epam.kiryanova_anna.java.lesson2.task2.airplane;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public class XMLAirplane {
    private final String name;
    private final String type;

    private final Map<String, String> parameter;
    private final Pair<String, String> route;

    public XMLAirplane(String name, String type, Map<String, String> parameter, Pair<String, String> route) {
        this.name = name;
        this.type = type;
        this.parameter = parameter;
        this.route = route;
    }

    @Override
    public String toString() {
        return name + " " + type + " " + route + " " + parameter;
    }
}
