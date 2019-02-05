package com.homeworks.rxJava;

import io.reactivex.Observable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RxJavaApp {
    private String result;

    @Test
    public void stringTest() {
        result = "";
        Observable<String> observer = Observable.just("Hello");
        observer.subscribe(s -> result = s);
        assertEquals("Hello", result);
    }
}
