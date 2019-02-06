package com.homeworks.algorithms.sortings;

public class BubbleSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                if (inputArray[i] < inputArray[j]) {
                    swap(inputArray, i, j);
                }
            }
        }
        return inputArray;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
