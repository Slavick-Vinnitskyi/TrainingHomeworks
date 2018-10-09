package com.homeworks.block1.task1;

import com.homeworks.block1.task1.controller.Controller;
import com.homeworks.block1.task1.model.Model;
import com.homeworks.block1.task1.view.View;

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(view, model);
        controller.action();
    }
}
