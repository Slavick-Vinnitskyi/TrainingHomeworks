package com.homeworks.patterns.structural.flyweight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Фабрика для гаранитирования отсутсвия дублирования экземпляров букв
        CharFactory charFactory = new CharFactory();
        ArrayList<EnglishCharacter> characters = new ArrayList<>();
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        programDriver(charFactory, characters, coordinates);

    }

    private static void programDriver(CharFactory charFactory, ArrayList<EnglishCharacter> characters, ArrayList<Coordinate> coordinates) {
        // Управление программой
        String read;
        int chooseOrFind;
        boolean flag = true;
        while (flag) {
            System.out.println("\n1--Введення тексту з консолі\n2--Введення тексту з файлу\n3--Вихід");
            chooseOrFind = ChooseAction(3);
            if (chooseOrFind == 1) {// Из консоли
                int line = 0, column = 0;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    read = bufferedReader.readLine();

                    for (char c : read.toCharArray()) {
                        characters.add(charFactory.getChar(c));
                        column++;
                        coordinates.add(new Coordinate(line, column));
                    }
                    output(characters, coordinates);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (chooseOrFind == 2) { // Из файла

                ReadFromFile fromFile = new ReadFromFile("D:\\Laba2\\src\\com\\lablll\\labwork4\\War and Peace", characters);
                coordinates = fromFile.read();
                output(characters, coordinates);
            } else flag = false;

        }
    }

    private static void output(ArrayList<EnglishCharacter> characters, ArrayList<Coordinate> coordinates) {
        int i = 0;
        for (Coordinate c : coordinates) {
            System.out.print(c.drawChar(characters.get(i)) + ", ");
            i++;
        }
        Map uniq = CharFactory.getShapes();
        System.out.println(composeToWords(characters));
        System.out.println("\nAmount of symbols : " + characters.size() + " Count of unique objects : " + uniq.size());
        uniq.forEach((k, v) -> System.out.print(k + ":" + v + "; "));
    }

    private static int ChooseAction(int max) {
        int num;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.printf("\nВедіть число від %d до %d: ", 1, max);
            while (!scan.hasNextInt()) {
                System.out.printf("Ведіть число!!! від %d до %d: ", 1, max);
                scan.next();
            }
            num = scan.nextInt();
        } while ((num > max) || (num < 1));
        return num;
    }

    private static String composeToWords(ArrayList<EnglishCharacter> chars) {
        StringBuilder temp = new StringBuilder("");
        for (EnglishCharacter c : chars) {
            temp.append(c.c);
        }
        String[] str = temp.toString().split("\\W"); //Split on non-word characters.

        StringBuilder rev = new StringBuilder("");
        int currentPosition = 0;
        for (String aStr : str) {
            for (int s = 0; s <= aStr.length() - 1; s++) {
                rev.append(aStr.charAt(s));
                currentPosition++;
            }
            while (currentPosition < temp.toString().length() && Character.toString(temp.toString().charAt(currentPosition)).matches("\\W"))
                rev.append(temp.toString().charAt(currentPosition++)); //Add the actual character there.
        }

        return rev.toString();
    }
}


