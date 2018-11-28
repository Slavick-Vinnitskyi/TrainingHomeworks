package com.homeworks.patterns.behavioral.state;

public class StateApp {
    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.setStation(new Radio7());
        for (int i = 0; i < 10; i++) {
            radio.nextStation();
            radio.play();
        }
    }
}

class Radio {
    private Station station;

    void setStation(Station station) {
        this.station = station;
    }

    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioFM());
        } else if (station instanceof RadioFM) {
            setStation(new RadioEU());
        } else if (station instanceof RadioEU) {
            setStation(new Radio7());
        }
    }

    void play() {
        station.play();
    }
}

interface Station {
    void play();
}

class Radio7 implements Station {

    @Override
    public void play() {
        System.out.println("Radio 7...");
    }
}

class RadioEU implements Station {

    @Override
    public void play() {
        System.out.println("Radio EU...");
    }
}

class RadioFM implements Station {

    @Override
    public void play() {
        System.out.println("Radio FM...");
    }
}