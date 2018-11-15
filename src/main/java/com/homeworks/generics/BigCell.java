package com.homeworks.generics;

public class BigCell<K, T> extends Cell<T> {
    private K firstBigItem;
    private T secondBigItem;

    public void setFirstBigItem(K firstBigItem, T secondBigItem) {
        this.firstBigItem = firstBigItem;
        this.secondBigItem = secondBigItem;
    }

    public K getFirstBigItem() {
        return firstBigItem;
    }

    public T getSecondBigItem() {
        return secondBigItem;
    }
}
