package com.homeworks.block4.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.homeworks.block4.view.TextConstants.INPUT_STRING_DATA;
import static com.homeworks.block4.view.TextConstants.WRONG_DATA;

public class View {
    //TODO : сдлеать ENUM для локалей
    //TODO: в Controller`e сделать по методу на валидацию каждой порции данных, в методах вызывать askData через do while
    private static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale("en"));

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


}
