package com.homeworks.block1;

import com.homeworks.block1.controller.Controller;
import com.homeworks.block1.model.Model;
import com.homeworks.block1.view.View;

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(view, model);
        controller.action();
    }
}
