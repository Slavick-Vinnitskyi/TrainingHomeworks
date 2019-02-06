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

    public int[] whileSort(int[] inputArray) {
        int size = inputArray.length;
        if (size <= 1) throw new RuntimeException();
        boolean b = true;
        while (b) {
            b = false;
            for (int i = 0; i + 1 < size; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    swap(inputArray, i, i + 1);
                    b = true;
                }
            }
        }
        return inputArray;
    }
}
