package com.homeworks.generics;

public class Main {
    public static void main(String[] args) {
        //Параметризируем наш обобщенный класс Cell
        Cell<String> stringCell = new Cell<>();
        stringCell.setItem("hello");
        String s = stringCell.getItem();
        System.out.println(s);

        //Параметризируем наш ограниченный сверху обобщенный класс Box
        Box<Integer> integerBox = new Box<>();
        integerBox.setNumber(45);
        System.out.println(integerBox.getNumber());

        //Параметризируем наш ограниченный сверху обобщенный класс Box
        Box<Double> doubleBox = new Box<>();
        doubleBox.setNumber(45.5D);
        System.out.println(doubleBox.getNumber());

        //Используем обобщенный класс Box в методе с метасимольным аргументом
        Human engineer = new Human();
        engineer.useBox(integerBox);

        BigCell<String, Integer> stringIntegerBigCell = new BigCell<>();
        stringIntegerBigCell.setFirstBigItem("Item", 100);
        System.out.println(stringIntegerBigCell.getFirstBigItem());
        System.out.println(stringIntegerBigCell.getSecondBigItem());

    }
}