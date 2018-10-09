package com.homeworks.block1.task1.controller;

import com.homeworks.block1.task1.model.Model;
import com.homeworks.block1.task1.view.View;

import java.util.Scanner;

public class Controller {

    private static final String HELLO = "Hello";
    private static final String WORLD = "World";

    //    References on Model and View
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void action() {
        Scanner sc = new Scanner(System.in);

        model.completeString(checkFidelity(sc, HELLO), checkFidelity(sc, WORLD));

        view.printMessage(model.getHelloString());
    }


    private String checkFidelity(Scanner scanner, String word) {

        String inputted;

        do {
            view.askForInput(word);

            inputted = scanner.next();
        }
        while (!inputted.toLowerCase().equals(word.toLowerCase()));

        return inputted;
    }
}
