package com.homeworks.concurrency;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SemaphoreApp {
    /**
     * Producer will add value to list
     * Consumer will take this value
     */
    private static LinkedList<String> list = new LinkedList<>();
    private static Semaphore semaphore = new Semaphore(0);
    private static Semaphore mutex = new Semaphore(1);


    public static void main(String[] args) {
        new Producer().start();
        new Consumer("Slavick").start();
        new Consumer("John").start();
        new Consumer("Frank").start();

    }

    static class Producer extends Thread {
        @Override
        public void run() {
            int counter = 1;
            try {
                while (true) {
                    String threadName = Thread.currentThread().getName() + counter++;
                    mutex.acquire();
                    list.add(threadName);
                    System.out.println("Producer has produced new value :" + threadName);
                    mutex.release();

                    semaphore.release();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer extends Thread {
        String consumerName;

        Consumer(String consumerName) {
            this.consumerName = consumerName;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    semaphore.acquire();
                    mutex.acquire();
                    String result = "";
                    for (String value : list) {
                        result = value + ",";
                    }
                    System.out.println(consumerName + " consumes value : " + result + "list.size() : " + list.size());
                    mutex.release();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
