package com.homeworks.block4.controller;

import com.homeworks.block4.model.Model;
import com.homeworks.block4.view.View;

import java.util.Scanner;

import static com.homeworks.block4.controller.RegexContainer.*;
import static com.homeworks.block4.view.TextConstants.*;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        settingUserData();
    }

    private void settingUserData() {
        Scanner scanner = new Scanner(System.in);
        UtilityController controller = new UtilityController(scanner, view);
        UserData userData = new UserData();

        String str = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_NAME_UKR : REGEX_NAME_LAT;
        String firstName = controller.inputStringValueWithScanner(ENTER_FIRST_NAME, str);
        String login = controller.inputStringValueWithScanner(LOGIN_DATA, REGEX_LOGIN);
        String telephone = controller.inputStringValueWithScanner(PHONE_DATA, REGEX_PHONE);

        userData.setData(firstName, login, telephone);
    }
}
