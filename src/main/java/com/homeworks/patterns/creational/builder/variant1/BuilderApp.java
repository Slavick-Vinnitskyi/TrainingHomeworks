package com.homeworks.patterns.creational.builder.variant1;

public class BuilderApp {
    public static void main(String[] args) {


        Car ford = new CarBuilder()
                .buildMaxSpeed(200)
                .buildTransmission(Transmission.AUTO)
                .build();
        System.out.println(ford);
    }
}

enum Transmission {
    MANUAL, AUTO
}

/**
 * Сущность для построения
 */
class Car {
    private String mark;
    private Transmission transmission;
    private int maxSpeed;

    void setMark(String mark) {
        this.mark = mark;
    }

    void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class CarBuilder {
    /**
     * Значения по умолчанию
     */
    private String mark = "Ford";
    private Transmission transmission = Transmission.MANUAL;
    private int maxSpeed = 120;


    CarBuilder buildMark(String mark) {
        this.mark = mark;
        return this;
    }

    CarBuilder buildTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    CarBuilder buildMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    Car build() {
        Car builtCar = new Car();
        builtCar.setMark(mark);
        builtCar.setTransmission(transmission);
        builtCar.setMaxSpeed(maxSpeed);
        return builtCar;
    }
}
