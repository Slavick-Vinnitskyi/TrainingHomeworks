package com.homeworks.block2;

import java.util.ArrayList;

/**
 * Получает данные.
 * Проверяет на валидность?Проверяет на полность? отдает модели: выводит сообщение о ошибке
 */
public class Controller {

    private static ArrayList<Integer> attemptsHistory = new ArrayList<>();
    private View view;
    private Model model;


    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }


    public void run(int min, int max) {
        model.setRandomNumber(min, max);
        model.setUserNumber(view.askNumber(min, max));
        while (!this.validateNumber(model.getUserNumber(), model.getRandomNumber())) {
            model.setUserNumber(view.askNumber(min, max));
        }
    }

    public boolean validateNumber(int userNumber, int randomNumber) {
        if (userNumber > randomNumber) {
            view.outputHigher();
            attemptsHistory.add(userNumber);
            return false;
        } else if (userNumber < randomNumber) {
            view.outputLower();
            attemptsHistory.add(userNumber);
            return false;
        } else {
            view.outputRightAnswer(attemptsHistory);
            return true;
        }
    }
}
