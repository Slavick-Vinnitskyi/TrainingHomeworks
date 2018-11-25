package com.homeworks.patterns.creational.singleton;


/**
 * Нету ленивой инициализации
 * (синглтон будет создаваться не всегжа когда нам нужно,
 * а при первом обращении к любому елементу этого класса)
 */
public class ThreadSafeSingleton {
    private static int counter = 0;
    private static ThreadSafeSingleton singleton = new ThreadSafeSingleton();

    private ThreadSafeSingleton() {
        counter++;
    }

    public static ThreadSafeSingleton getSingleton() {
        return singleton;
    }

    public static int getCounter() {
        return counter;
    }
}

class ThreadSafeSingletonApp {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(ThreadSafeSingleton::getSingleton);
        }
        for (int i = 0; i < 1000; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 1000; i++) {
            threads[i].join();
        }
        System.out.println("ThreadSafeSingleton.getCounter() = " + ThreadSafeSingleton.getCounter());
    }
}