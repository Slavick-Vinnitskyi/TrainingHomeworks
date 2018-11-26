package com.homeworks.patterns.creational.abstract_factory.university_variant;

public class Main {
    public static void main(String[] args) {

        ApiFactory factory = getFactory("QT");
        Button button = factory.createButton();
        button.paint();
    }


    private static ApiFactory getFactory(String api) {
        switch (api.toLowerCase()) {
            case "win":
                return new WinApi();
            case "gtk":
                return new GtkApi();
            case "qt":
                return new QtApi();
            default:
                throw new RuntimeException("No such api :" + api);
        }
    }
}
