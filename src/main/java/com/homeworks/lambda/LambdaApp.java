package com.homeworks.lambda;

import java.util.concurrent.*;

public class LambdaApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> c = () -> 2 + 2;
        final ExecutorService service = Executors.newFixedThreadPool(1);
        final Future<Integer> result = service.submit(c);
        final Integer integer = result.get();
        System.out.println(integer);
        service.shutdown();
    }
}

