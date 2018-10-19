package com.homeworks.block4.controller;

import com.homeworks.block4.model.Model;
import com.homeworks.block4.view.View;

import java.util.Scanner;


public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        UserData inputNoteNoteBook =
                new UserData(view, sc);
        inputNoteNoteBook.setData();
    }
}
