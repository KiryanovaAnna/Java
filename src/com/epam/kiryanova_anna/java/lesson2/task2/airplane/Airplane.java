package com.epam.kiryanova_anna.java.lesson2.task2.airplane;

public class Airplane {
    private final String manufacturer;
    private final String model;

    private final int capacity;
    private final double carrying;
    private final double range;

    public Airplane(String manufacturer, String model, int capacity, double carrying, double range) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.capacity = capacity;
        this.carrying = carrying;
        this.range = range;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getCarrying() {
        return carrying;
    }

    public double getRange() {
        return range;
    }

    @Override
    public String toString() {
        return manufacturer + " " + model + " " + capacity + " " + carrying + " " + range;
    }
}
