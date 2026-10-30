package ru.vladify.vshum.javaguru;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountNumberInArrayTask {
    public static void main(String[] args) {
        check();
    }

    private static int maxRepeatingNumber(int[] array) {

        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.<Integer, Long>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    private static void check() {
        System.out.println("Ожидается: 8    получено: " + maxRepeatingNumber(new int[]{3, 0, 8, 8, 0}));  // 0, 8
        System.out.println("Ожидается: 5    получено: " + maxRepeatingNumber(new int[]{3, 8, 8, 7, 5, 3, 5, 5, 7, 1}));  // 5
        System.out.println("Ожидается: 7    получено: " + maxRepeatingNumber(new int[]{7, 2, 7, 6, 4, 0, 5, 3, 4, 6}));  // 6, 7, 4
        System.out.println("Ожидается: 3    получено: " + maxRepeatingNumber(new int[]{1, 0, 8, 8, 5, 6, 8, 0, 0, 1, 3, 3, 2, 4, 2, 5, 0, 3, 7, 3})); // 0, 3
    }
}
