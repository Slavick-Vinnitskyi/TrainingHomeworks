package com.homeworks.block2;

import java.util.Random;

/**
 * Реализует техническое задание(бизнесс-логику)
 * Не должна меняться, пока не изменилось ТЗ
 */
public class Model {

    private  int randomNumber;
    private  int userNumber;


    public void setRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Максимальное должно быть больше минимального!!");
        }

        Random random = new Random();
        this.randomNumber = random.nextInt((max - min) + 1) + min;
    }


    public int getRandomNumber() {
        return this.randomNumber;
    }


    public int getUserNumber() {
        return userNumber;
    }


    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
}
