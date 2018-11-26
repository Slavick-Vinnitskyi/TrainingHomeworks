package com.homeworks.patterns.structural.decorator;

public interface Figure {

    String show();

    Figure undecorate();

    Figure removeDecoration(String className);

//    Figure createDecoration(Figure toDecorate, String... classToDecorate);

    String nonDecoratedString();
}
