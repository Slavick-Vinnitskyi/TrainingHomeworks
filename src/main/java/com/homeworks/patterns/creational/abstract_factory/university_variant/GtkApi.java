package com.homeworks.patterns.creational.abstract_factory.university_variant;

public class GtkApi implements ApiFactory {

    @Override
    public Button createButton() {
        return new GthApiButton();
    }
}
