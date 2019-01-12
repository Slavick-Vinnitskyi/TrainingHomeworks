package com.homeworks;

import java.util.*;

public class AnagramApp {
    public static void main(String[] args) {
        List<Long> times = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            isAnagram("StringS", "StringS");
            isAnagram("PString", "KeysetS");
            long end = System.nanoTime() - start;
            times.add(end);
        }
        System.out.println("1 = " + times.stream().mapToInt(Long::intValue).average().getAsDouble());

        List<Long> times1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            isAnagram1("StringS", "StringS");
            isAnagram1("PString", "KeysetS");
            long end = System.nanoTime() - start;
            times1.add(end);
        }
        System.out.println("2 = " + times1.stream().mapToInt(Long::intValue).average().getAsDouble());
    }

    private static boolean isAnagram(String one, String two) {
        if (one.length() != two.length())
            return false;

        Map<Character, Integer> compareMap = new HashMap<>();

        for (Character c :
                one.toCharArray()) {
            compareMap.merge(c, 1, (oldVal, increment) -> oldVal + increment);
        }

        for (Character c : two.toCharArray()) {
            if (!compareMap.containsKey(c)) {
                return false;
            }
            compareMap.merge(c, 1, (oldVal, decrement) -> oldVal - decrement);
        }

        return compareMap.values().stream().noneMatch(x -> x != 0);
    }


    private static boolean isAnagram1(String one, String two) {
        if (one.length() != two.length())
            return false;
        char[] oneArr = one.toCharArray();
        Arrays.sort(oneArr);
        char[] twoArr = two.toCharArray();
        Arrays.sort(twoArr);
        for (int i = 0; i < oneArr.length; i++) {
            if (oneArr[i] != twoArr[i]) {
                return false;
            }
        }
        return true;
    }
}