package com.homeworks.algorithms.sortings;

/**
 * Сделаем так, чтобы отсортирован был некоторый префикс исходного массива,
 * вместо вставки будем менять текущий элемент с предыдущим,
 * пока они стоят в неправильном порядке.
 */
public class InsertionSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] array) {
        int size = array.length;
        if (size <= 1) throw new RuntimeException();

        for (int i = 0; i < size - 1; i++) {
            int j = i;
            while (j >= 0 && (array[j]) > array[j + 1]) {
                swap(array, j, j + 1);
                j--;
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}