package com.homeworks.algorithms.sortings;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingManager {
    private static final int START = 0;
    private static final int END = 20;

    public static void main(String[] args) {
        SortAlgorithm algorithm = new QuickSort();
        int[] array = IntStream
                .range(START, END)
                .map(i -> START + (END - i - 1))
                .toArray();
        System.out.println(Arrays.toString(array));
        SortingContext context = new SortingContext(algorithm , array);
        context.sort();
        System.out.println(Arrays.toString(array));
    }
}