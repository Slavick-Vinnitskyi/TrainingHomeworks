package com.homeworks.algorithms.sortings;

import java.security.InvalidParameterException;

/**
 * Идём не только слева направо, но и справа налево,
 * чтобы уменьшить вероятность "черепахи"
 */
public class ShakerSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] inputArray) {
        if(inputArray.length < 1) {
            throw new InvalidParameterException();
        }
        boolean b = true;
        int begin = -1;
        int end = inputArray.length - 1;

        while (b) {
            b = false;
            begin++;
            for (int i = begin; i < end; i++){
                if(inputArray[i] > inputArray[i + 1]) {
                    swap(inputArray, i);
                    b = true;
                }
            }
            if(!b) break;
            end--;
            for (int i = end; i > begin; i--) {
                if(inputArray[i] < inputArray[i - 1]) {
                    swap(inputArray, i - 1);
                    b = true;
                }
            }
        }
        return inputArray;
    }

    private void swap(int[] array, int i) {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
    }
}
