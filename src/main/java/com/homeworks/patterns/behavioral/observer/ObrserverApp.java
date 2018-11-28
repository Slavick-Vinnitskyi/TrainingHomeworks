package com.homeworks.patterns.behavioral.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ObrserverApp {
    public static void main(String[] args) {
        ConsoleObserver consoleObserver = new ConsoleObserver();
        FileObserver fileObserver = new FileObserver();
        MeteoStation meteoStation = new MeteoStation();
        meteoStation.addObserver(consoleObserver);
        System.out.println(LocalDateTime.now());
        meteoStation.setMeasurements(30, 89);
        System.out.println(LocalDateTime.now());
        meteoStation.addObserver(fileObserver);
        meteoStation.setMeasurements(32, 34);
    }
}

/**
 * Наблюдатель
 */
interface Observed {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

/**
 * Конкретный наблюдатель
 */
class MeteoStation implements Observed {
    private int temperature;
    private int pressure;
    private List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer {
    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer {

    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("Weather has changed. Temp = " + temp + "; Pressure = " + presser);
    }
}

class FileObserver implements Observer {

    @Override
    public void handleEvent(int temp, int presser) {
        File file;
        try {
            file = File.createTempFile("TempPressure", ".txt");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print("Temp = " + temp + "; Pressure = " + presser);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}