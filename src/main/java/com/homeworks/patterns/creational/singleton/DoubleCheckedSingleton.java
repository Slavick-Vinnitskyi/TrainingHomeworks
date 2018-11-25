package com.homeworks.patterns.creational.singleton;

public class DoubleCheckedSingleton {
    private static int counter = 0;
    private static volatile DoubleCheckedSingleton singleton = null;

    private DoubleCheckedSingleton() {
        counter++;
    }

    public static DoubleCheckedSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckedSingleton();
                }
            }
        }
        return singleton;
    }

    public static int getCounter() {
        return counter;
    }
}

class DoubleCheckedSingletonApp {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(DoubleCheckedSingleton::getSingleton);
        }
        for (int i = 0; i < 1000; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 1000; i++) {
            threads[i].join();
        }
        System.out.println("ThreadSafeSingleton.getCounter() = " + DoubleCheckedSingleton.getCounter());
    }
}