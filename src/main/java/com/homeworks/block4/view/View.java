package com.homeworks.block4.view;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static com.homeworks.block4.view.TextConstants.INPUT_STRING_DATA;
import static com.homeworks.block4.view.TextConstants.WRONG_DATA;

public class View {

    private static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale("ua", "UA"));


    public String askData(String ask) {
        System.out.println(ask);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public void printStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }

    public void printWrongStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(WRONG_DATA),
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }

//    TODO: в Controller`e сделать по методу на валидацию каждой порции данных, в методах вызывать askData через do while
}
