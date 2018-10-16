package com.homeworks.block2.task2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Демонстрация данных согласно ТЗ
 */
public class View {
    private final static String YOUR_NUMBER_IS_LOWER = "Вы загадали число ниже";
    private final static String YOUR_NUMBER_IS_HIGHER = "Вы загадали число выше";
    private final static String YOU_RIGHT = "Вы угадали! Ура !!!!!!";
    private final static String YOUR_HISTORY = "Ваша история попыток :";

    public int askNumber(int min, int max) {
        int num;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.printf("Введите число от %d к %d: ", min, max);
            while (!scan.hasNextInt()) {
                System.out.printf("Введите!!! от %d к %d: ", min, max);
                scan.next();
            }
            num = scan.nextInt();
        } while ((num > max) || (num < min));
        return num;
    }


    public void outputHigher() {
        System.out.println(YOUR_NUMBER_IS_HIGHER);
    }


    public void outputLower() {
        System.out.println(YOUR_NUMBER_IS_LOWER);
    }

    public void outputRightAnswer(ArrayList <Integer> attemptsHistory) {
        System.out.println(YOU_RIGHT);
        System.out.println(YOUR_HISTORY);
        attemptsHistory.forEach((value) -> System.out.print(value + " "));
    }
}
