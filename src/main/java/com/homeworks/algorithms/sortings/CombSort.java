package com.homeworks.algorithms.sortings;

import java.security.InvalidParameterException;

/**
 * Переставляем элементы на расстоянии,
 *  чтобы избавиться от "черепах"
 *  Оптимально изначально взять расстояние равным длине массива,
 *  а далее делить его на некоторый коэффициент,
 *  равный примерно 1.247.
 *  Проходим расческой пока шаг != 1
 *  Далее выполняем сортировку пузырьком
 */
public class CombSort implements SortAlgorithm {
    private final static double KOEF = 1.2473309;


    @Override
    public int[] sort(int[] inputArray) {
        int size = inputArray.length;
        int step = size - 1;
        if (size <= 1) {
            throw new InvalidParameterException();
        }
        while (step > 1) {
            for (int i = 0; i + step < size; i++) {
                if (inputArray[i] > inputArray[i + step]) {
                    swap(inputArray, i, i + step);
                }
                step /= KOEF;
            }

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
        }
        return inputArray;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
