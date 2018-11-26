package com.homeworks.patterns.behavioral.strategy;

public class Decart implements Coordinates {

    @Override
    public void draw(double x, double y) {

        System.out.printf("x : %.3f y : %.3f\n", x, y);

    }
}
