package com.homeworks.algorithms.sortings;

public class SortingContext {
    private SortAlgorithm algorithm;
    private int[] array;

    public SortingContext(SortAlgorithm algorithm, int[] array) {
        this.algorithm = algorithm;
        this.array = array;
    }

    public void setAlgorithm(SortAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void sort() {
        algorithm.sort(array);
    }
}
