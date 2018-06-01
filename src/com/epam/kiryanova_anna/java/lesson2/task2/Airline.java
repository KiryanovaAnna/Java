package com.epam.kiryanova_anna.java.lesson2.task2;

import com.epam.kiryanova_anna.java.lesson2.task2.airplane.Airplane;
import com.epam.kiryanova_anna.java.lesson2.task2.airplane.airbus.planes.AirbusA320;
import com.epam.kiryanova_anna.java.lesson2.task2.airplane.airbus.planes.AirbusA340;
import com.epam.kiryanova_anna.java.lesson2.task2.airplane.boeing.planes.Boeing737;
import com.epam.kiryanova_anna.java.lesson2.task2.airplane.boeing.planes.Boeing777;
import com.epam.kiryanova_anna.java.lesson2.task2.airplane.embraer.Embraer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Airline {
    List<Airplane> planes = new ArrayList<>();

    public Airline(Airplane... airplanes) {
        for (Airplane airplane : airplanes)
            planes.add(airplane);
    }

    public int totalCapacity() {
        int sum = 0;

        for (int i = 0; i < planes.size(); i++)
            sum += planes.get(i).getCapacity();

        return sum;
    }

    public int totalCarrying() {
        int sum = 0;

        for (int i = 0; i < planes.size(); i++)
            sum += planes.get(i).getCarrying();

        return sum;
    }

    public List<Airplane> sortByRange() {
        planes.sort(Comparator.comparingDouble(Airplane::getRange));

        return planes;
    }

    public List<Airplane> findPlane(String manufacture, String model, Integer capacity1, Integer capacity2,
                                      Double carrying1, Double carrying2, Double range1, Double range2) {
        List<Airplane> result = new ArrayList<>();

        for (int i = 0; i < planes.size(); i++) {
            Airplane airplane = planes.get(i);

            if (manufacture != null && !airplane.getManufacturer().equals(manufacture))
                continue;

            if (model != null && !airplane.getModel().equals(model))
                continue;

            int capacity = airplane.getCapacity();
            if (capacity1 != null && capacity1 > capacity || capacity2 != null && capacity2 < capacity)
                continue;

            double carrying = airplane.getCapacity();
            if (carrying1 != null && carrying1 > carrying || carrying2 != null && carrying2 < carrying)
                continue;

            double range = airplane.getRange();
            if (range1 != null && range1 > carrying || range2 != null && range2 < range)
                continue;

            result.add(airplane);
        }

        return result;
    }

    public static void main(String[] args) {
        Airline airline = new Airline(
                new Boeing777(),
                new Boeing737(),
                new Boeing777(),

                new AirbusA320(),
                new AirbusA340(),

                new Embraer(
                        "E170",72 , 0,3982
                )
        );

        System.out.println(airline.totalCapacity());
        System.out.println(airline.totalCarrying());

        System.out.println(airline.sortByRange());
        System.out.println(airline.findPlane(
                "Embraer",
                "E190",
                null, null,
                null, null,
                null, null
        ));
    }
}
