package com.homeworks.block2.task2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *  Игровая JAVA – программа, которая отгадывает число по принципу – «больше – меньше» :
 *
 * 1. Программа должна загадать произвольное число в диапазоне от 0 до 100.
 * 2. Пользователю предлагается попробовать угадать число путем последовательного ввода чисел из диапазона ограниченного сначала числами 0 и 100, а при дальнейших попытках – с учетом ранее введенных чисел. Программа должна анализировать ввод на любые ошибочные действия пользователя.
 * 3. На экране должно отображаться предыдущие попытки, диапазон, в котором находится искомое число и результат предыдущего действия пользователя.
 * 4. При совпадении чисел – программа должна сообщить об этом пользователю и вывести всю статистику по действиям пользователя.
 */
public class Main {
    private static int randomNumber;
    private static int userNumber;
    private static ArrayList<Integer> attemptsHistory = new ArrayList<>();

    public static void main(String[] args) {
        setRandomNumber(0, 100);
        setUserNumber(askNumber(0,100));
        while (!validateNumber(getUserNumber(), getRandomNumber())) {
            setUserNumber(askNumber(0,100));
        }
    }

    public static void setRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random random = new Random();
        Main.randomNumber = random.nextInt((max - min) + 1) + min;
    }

    private static int getRandomNumber() {
        return Main.randomNumber;
    }

    private static int askNumber(int min, int max) {
        int num;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.printf("Введіть число від %d до %d: ", min, max);
            while (!scan.hasNextInt()) {
                System.out.printf("Ведіть число!!! від %d до %d: ", min, max);
                scan.next();
            }
            num = scan.nextInt();
        } while ((num > max) || (num < min));
        return num;
    }

    private static boolean validateNumber(int userNumber, int randomNumber) {
        if (userNumber > randomNumber) {
            System.out.println("Вы загадали число выше:");
            attemptsHistory.add(userNumber);
            return false;
        } else if (userNumber < randomNumber) {
            System.out.println("Вы загадали число ниже:");
            attemptsHistory.add(userNumber);
            return false;
        } else {
            System.out.println("Вы угадали! Ура !!!!!!");
            System.out.println("Ваша история попыток :");
            attemptsHistory.forEach((value) -> System.out.print(value + " "));
            return true;
        }
    }

    public static int getUserNumber() {
        return userNumber;
    }

    public static void setUserNumber(int userNumber) {
        Main.userNumber = userNumber;
    }
    //TODO : Разделить на MVC
}

