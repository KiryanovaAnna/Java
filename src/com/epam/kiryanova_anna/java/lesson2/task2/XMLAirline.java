package com.epam.kiryanova_anna.java.lesson2.task2;

import com.epam.kiryanova_anna.java.lesson2.task2.airplane.XMLAirplane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLAirline {
    List<XMLAirplane> planes = new ArrayList<>();

    public XMLAirline(XMLAirplane... airplanes) {
        planes.addAll(Arrays.asList(airplanes));
    }

    public void addPlane(XMLAirplane airplane) {
        planes.add(airplane);
    }

    @Override
    public String toString() {
        return planes.toString();
    }
}
