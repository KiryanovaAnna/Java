package com.epam.kiryanova_anna.java.lesson2.task2.airplane;

import com.epam.kiryanova_anna.java.lesson2.task2.airplane.airbus.planes.AirbusA340;
import com.epam.kiryanova_anna.java.lesson2.task2.airplane.boeing.planes.Boeing777;

import java.io.*;

public class AirplaneConnector {
    private Airplane airplane;
    private final File file;

    public AirplaneConnector(Airplane airplane, File file) {
        this.airplane = airplane;
        this.file = file;

        serialize();
    }

    public AirplaneConnector(File file) {
        this.file = file;
        deserialize();
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
        serialize();
    }

    public void serialize() {
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(airplane);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void deserialize() {
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            airplane = (Airplane) in.readObject();

            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }

    public Airplane getAirplane() {
        return airplane;
    }
}
