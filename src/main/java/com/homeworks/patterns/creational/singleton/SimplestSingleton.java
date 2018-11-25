package com.homeworks.patterns.creational.singleton;

import java.util.ArrayList;
import java.util.List;

public class SimplestSingleton {
    private static int counter = 0;
    private static SimplestSingleton singleton;

    private SimplestSingleton() {
        counter++;
    }

    public static SimplestSingleton getSingleton() {
        if (singleton == null) {
            singleton = new SimplestSingleton();
        }
        return singleton;
    }

    public static int getCounter() {
        return counter;
    }
}

class SingletonApp {
    public static void main(String[] args) {
        List<SimplestSingleton> singletonAppList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            SimplestSingleton singleton = SimplestSingleton.getSingleton();
            singletonAppList.add(singleton);
        }
        System.out.println("s.getCounter() = " + SimplestSingleton.getCounter());
    }
}
