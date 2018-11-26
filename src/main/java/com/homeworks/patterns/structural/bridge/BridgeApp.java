package com.homeworks.patterns.structural.bridge;

public class BridgeApp {
    public static void main(String[] args) {
        Car car = new Hatchback(new Skoda());
        car.showDetails();
    }
}

abstract class Car {
    Make make;
    private String type;

    public Car(Make make, String type) {
        this.make = make;
        this.type = type;
    }

    abstract void showDetails();

    public String getType() {
        return type;
    }
}

class Sedan extends Car {

    public Sedan(Make make) {
        super(make, "Sedan");
    }


    @Override
    void showDetails() {
        make.setMake();
        System.out.println(getType());
    }
}

class Hatchback extends Car {


    public Hatchback(Make make) {
        super(make, "Hatchback");
    }

    @Override
    void showDetails() {
        make.setMake();
        System.out.println(getType());
    }

}

interface Make {
    void setMake();
}

class Kia implements Make {
    @Override
    public void setMake() {
        System.out.println("Kia");
    }
}

class Skoda implements Make {

    @Override
    public void setMake() {
        System.out.println("Skoda");
    }
}
