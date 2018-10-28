package com.homeworks.arrayAlgorithms;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] firstArray = generateArray(10, 0, 20);
        int[] secondArray = generateArray(10, 0, 15);
        int[] mergedArray = mergeArrays(firstArray, secondArray);
        outputArrays(firstArray, secondArray, mergedArray);

        int[] arrayForSwap = generateArray(40, -10, 10);
        outputArray("\nbefore swap", arrayForSwap);
        swap(arrayForSwap);
        outputArray("\nafter swap", arrayForSwap);
        System.out.println();
        countEachElementInArray(arrayForSwap);

    }

    private static int[] generateArray(int size, int lowBound, int topBound) {
        return new Random().ints(size, lowBound, topBound).sorted().toArray();
    }

    private static int[] mergeArrays(int[] firstArray, int[] secondArray) {
        int[] mergedArray = new int[firstArray.length + secondArray.length];
        int i = 0, j = 0, k = 0;
        while (i < firstArray.length && j < secondArray.length) {
            if (firstArray[i] < secondArray[j]) {
                mergedArray[k++] = firstArray[i++];
            } else {
                mergedArray[k++] = secondArray[j++];

            }
        }
        while (i < firstArray.length)
            mergedArray[k++] = firstArray[i++];

        while (j < secondArray.length)
            mergedArray[k++] = secondArray[j++];


        return mergedArray;
    }

    private static void outputArrays(int[] firstArray, int[] secondArray, int[] mergedArray) {
        System.out.println("first array : ");
        Arrays.stream(firstArray).forEach(x -> System.out.print(x + " "));
        System.out.println("\nsecond array : ");
        Arrays.stream(secondArray).forEach(x -> System.out.print(x + " "));
        System.out.println("\nmerged array : ");
        Arrays.stream(mergedArray).forEach(x -> System.out.print(x + " "));
    }


    private static void swap(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                for (int j = array.length - 1; j >= 0; j--) {
                    if (array[j] < 0) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    private static void outputArray(String message, int[] array) {
        System.out.println(message + " : ");
        Arrays.stream(array).forEach(x -> System.out.print(x + " "));

    }

    private static void countEachElementInArray(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>(array.length);

        for (int value : array) {

            countMap.merge(value, 1, (a, b) -> a + b); /* ==  if (countMap.get(value) == null) countMap.put(value, 1)  else countMap.put(value, count++);*/
        }

        countMap.forEach((k, v) -> System.out.print(k + " : " + v + "; "));
    }
}
