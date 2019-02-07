package com.homeworks.algorithms.sortings;

public class QuickSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] inputArray) {
        return quickSort(inputArray, 0 , inputArray.length);
    }

    private int[] quickSort(int[] inputArray, int left, int right) {
        if(right - left <= 1)
            return inputArray;
        int lleft = left;
        int rright = right -1;
        int pivot = inputArray[(left + (right- left) / 2)];
        while (lleft <= rright) {
            while (inputArray[lleft] < pivot) {
                lleft++;
            }
            while (inputArray[rright] > pivot) {
                rright--;
            }
            if(lleft <= rright) {
                swap(inputArray, lleft, rright);
                lleft++;
                rright--;
            }
        }
        if(left < rright) this.quickSort(inputArray, left, rright);
        if(lleft < right) this.quickSort(inputArray, lleft, right);
        return inputArray;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
