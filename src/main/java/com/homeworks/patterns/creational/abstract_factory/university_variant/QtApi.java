package com.homeworks.patterns.creational.abstract_factory.university_variant;

public class QtApi implements ApiFactory {
    @Override
    public Button createButton() {
        return new QtButton();
    }
}
