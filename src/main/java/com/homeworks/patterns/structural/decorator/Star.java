package com.homeworks.patterns.structural.decorator;

public class Star extends FigureDecorator {
    public Star(Figure figure) {
        super(figure);
    }


    public String showStar() {
        return " со звездой";
    }

    @Override
    public String show() {
        return super.show() + showStar();
    }

    @Override
    public Figure undecorate() {
        return super.undecorate();
    }
}
