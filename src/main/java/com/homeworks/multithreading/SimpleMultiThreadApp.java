package com.homeworks.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class SimpleMultiThreadApp {
    public static void main(String[] args) {

        Map<Object, Object> map = new HashMap<>();
        map.put(null, "def");
        System.out.println(map.get(null));
        map.put("def", null);
        System.out.println(map.get("def"));
        Thread thread = new Thread(new Function());

        thread.start();


    }
}

class Function implements Runnable {
    @Override
    public void run() {
        System.out.println("runned");
//        Thread th = Thread.currentThread().getState();

    }
}

class Function1 implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}
