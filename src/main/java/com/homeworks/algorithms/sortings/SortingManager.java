package com.homeworks.algorithms.sortings;

import java.util.Arrays;

public class SortingManager {
    public static void main(String[] args) {
        SortAlgorithm algorithm = new QuickSort();
        int [] array = new int [] {9, 8, 7, 5, 4, 3, 2, 1};
        SortingContext context = new SortingContext(algorithm , array);
        context.sort();
        System.out.println(Arrays.toString(array));

    }
}
