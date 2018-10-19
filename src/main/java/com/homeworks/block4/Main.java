package com.homeworks.block4;

import com.homeworks.block4.controller.Controller;
import com.homeworks.block4.model.Model;
import com.homeworks.block4.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }
}
