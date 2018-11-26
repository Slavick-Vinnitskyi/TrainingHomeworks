package com.homeworks.patterns.structural.facade;

public class FacadeApp {
    public static void main(String[] args) {
        Computer myComputer = new Computer();
        myComputer.copy();

    }
}

/**
 * Facade class
 */
class Computer {
    private Power power = new Power();
    private DVDRom dvdRom = new DVDRom();
    private HDD hdd = new HDD();

    void copy() {
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power {
    void on() {
        System.out.println("Power on");
    }

    void of() {
        System.out.println("Power off");
    }
}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load() {
        data = true;
    }

    void unLoad() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvdRom) {
        if (dvdRom.hasData()) {
            System.out.println("Data is copying from disk...");
        } else {
            System.out.println("Input the disc with data!");
        }
    }
}