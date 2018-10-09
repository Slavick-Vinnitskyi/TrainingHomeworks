package com.homeworks.block1.task1.view;

public class View {

    private static final String WAS_INPUTTED = "Please, input : ";

    public void askForInput(String word) {

        System.out.println(WAS_INPUTTED + word);

    }

    public void printMessage(String message) {

        System.out.println(message);
    }
}
