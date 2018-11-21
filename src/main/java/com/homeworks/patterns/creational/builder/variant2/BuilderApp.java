package com.homeworks.patterns.creational.builder.variant2;


public class BuilderApp {
    public static void main(String[] args) {

        Director director = new Director();
        director.setCarBuilder(new FordMondeoBuilder());
        Car car = director.buildCar();
        System.out.println(car);
        director.setCarBuilder(new SubaruImprezaBuilder());
        Car car1 = director.buildCar();
        System.out.println(car1);
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


/**
 * Абстрактный класс билдера
 */
abstract class CarBuilder {
    Car car;

    void createCar() {
        car = new Car();
    }


    Car getCar() {
        return car;
    }

    abstract void buildMark();

    abstract void buildTransmission();

    abstract void buildMaxSpeed();
}


/**
 * Конкретный класс билдера
 */
class FordMondeoBuilder extends CarBuilder {
    @Override
    void buildMark() {
        car.setMark("Ford Mondeo");

    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);

    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(160);
    }
}

/**
 * Конкретный класс билдера
 */
class SubaruImprezaBuilder extends CarBuilder {
    @Override
    void buildMark() {
        car.setMark("Subaru Impreza");

    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(210);
    }
}

/**
 * Класс распорядитель
 * конструирует объект, пользуясь абстрактрным билдером
 */
class Director {

    private CarBuilder carBuilder;

    void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    Car buildCar() {
        carBuilder.createCar();
        carBuilder.buildMark();
        carBuilder.buildTransmission();
        carBuilder.buildMaxSpeed();
        return carBuilder.getCar();
    }
}
