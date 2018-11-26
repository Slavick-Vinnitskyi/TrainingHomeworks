package com.homeworks.patterns.creational.abstract_factory.university_variant;

public class WinApi implements ApiFactory {
    @Override
    public Button createButton() {
        return new WinApiButton();
    }
}
