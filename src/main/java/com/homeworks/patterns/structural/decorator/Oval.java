package com.homeworks.patterns.structural.decorator;

public class Oval extends FigureDecorator {
    public Oval(Figure figure) {
        super(figure);
    }

    public String showOval() {
        return " с овалом";
    }

    @Override
    public String show() {
        return super.show() + showOval();
    }

    @Override
    public Figure undecorate() {
        return super.undecorate();
    }
}
