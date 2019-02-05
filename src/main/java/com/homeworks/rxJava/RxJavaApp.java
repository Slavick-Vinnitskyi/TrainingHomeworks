package com.homeworks.rxJava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RxJavaApp {
    private String result = "";
    private Integer intResult = 0;

    @Test
    public void stringTest() {
        Observable<String> observer = Observable.just("Hello");
        observer.subscribe(s -> result = s);
        assertEquals("Hello", result);
    }

    @Test
    public void printingSum() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        Observable
                .fromIterable(integers)
                .subscribe(new Observer<Integer>() {

                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        intResult += integer;
                        System.out.println(intResult);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        intResult += 100;
                        System.out.println(intResult);
                    }
                });
    }

    @Test
    public void reactiveArrayTest() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        Observable<String> observable = Observable.fromArray(letters);
        observable.subscribe(
                i -> result += i, // onNext
                Throwable::printStackTrace, //onError
                () -> result += "_Completed"
        );
        assertEquals("abcdefg_Completed", result);
    }
}
