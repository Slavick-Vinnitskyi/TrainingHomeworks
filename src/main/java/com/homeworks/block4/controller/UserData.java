package com.homeworks.block4.controller;

import com.homeworks.block4.view.View;

import java.util.Scanner;

import static com.homeworks.block4.controller.RegexContainer.*;
import static com.homeworks.block4.view.TextConstants.*;

public class UserData {
    private View view;
    private Scanner scanner;

    private String firstName;
    private String login;

    public UserData(View view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }

    public void setData() {
        UtilityController controller = new UtilityController(scanner, view);
        String str = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_NAME_UKR : REGEX_NAME_LAT;
        this.firstName = controller.inputStringValueWithScanner(ENTER_FIRST_NAME, str);
        this.login = controller.inputStringValueWithScanner
                (LOGIN_DATA, REGEX_LOGIN);
    }
}
