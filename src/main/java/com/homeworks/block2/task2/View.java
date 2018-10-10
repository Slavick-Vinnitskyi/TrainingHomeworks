package com.homeworks.block2.task2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Демонстрация данных согласно ТЗ
 */
public class View {

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
        System.out.println("Вы загадали число выше");
    }


    public void outputLower() {
        System.out.println("Вы загадали число ниже");
    }

    public void outputRightAnswer(ArrayList <Integer> attemptsHistory) {
        System.out.println("Вы угадали! Ура !!!!!!");
        System.out.println("Ваша история попыток :");
        attemptsHistory.forEach((value) -> System.out.print(value + " "));
    }
}
