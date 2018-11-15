package com.homeworks.generics;

public class Human {
    public void useBox(Box<?> box) {
        int parseInt = Integer.parseInt(box.getNumber().toString());
        int changedValueFromBox = parseInt + 1;
        System.out.println(changedValueFromBox);
    }
}
