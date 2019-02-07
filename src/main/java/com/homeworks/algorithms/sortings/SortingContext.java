package com.homeworks.algorithms.sortings;

public class SortingContext {
    private SortAlgorithm algorithm;
    private int[] array;

    SortingContext(SortAlgorithm algorithm, int[] array) {
        this.algorithm = algorithm;
        this.array = array;
    }

    public void sort() {
        algorithm.sort(array);
    }
}
