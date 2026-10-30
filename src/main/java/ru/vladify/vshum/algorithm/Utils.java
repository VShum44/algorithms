package ru.vladify.vshum.algorithm;

import java.util.*;

public final class Utils {

    private Utils() {
        // Запрещаем создание экземпляров утилитного класса
    }

    public static void runTest(
            String testName,
            boolean actual,
            boolean expected
    ) {
        boolean passed = actual == expected;

        System.out.println(
                testName
                        + " | ожидалось: " + expected
                        + ", получено: " + actual
                        + " -> " + (passed ? "OK" : "FAIL")
        );
    }

    public static void runTest(
            String testName,
            int[] actual,
            int[] expected
    ) {
        boolean passed = Arrays.equals(actual, expected);

        System.out.println(
                testName
                        + " | ожидалось: " + Arrays.toString(expected)
                        + ", получено: " + Arrays.toString(actual)
                        + " -> " + (passed ? "OK" : "FAIL")
        );
    }

    public static void runTest(
            String first,
            String second,
            boolean actual,
            boolean expected
    ) {
        boolean passed = actual == expected;

        System.out.println(
                "Строки: \"" + first + "\", \"" + second + "\""
                        + " | ожидалось: " + expected
                        + ", получено: " + actual
                        + " -> " + (passed ? "OK" : "FAIL")
        );
    }

    public static void runTest(
            String testName,
            String[] input,
            List<List<String>> actual,
            List<List<String>> expected
    ) {
        boolean passed = normalize(actual).equals(normalize(expected));

        System.out.println(
                testName
                        + " | " + (passed ? "OK" : "FAIL")
                        + "\n  вход:      " + Arrays.toString(input)
                        + "\n  ожидалось: " + expected
                        + "\n  получено:  " + actual
        );
    }

    private static List<List<String>> normalize(List<List<String>> groups) {
        List<List<String>> normalized = new ArrayList<>();

        for (List<String> group : groups) {
            List<String> sortedGroup = new ArrayList<>(group);
            Collections.sort(sortedGroup);
            normalized.add(sortedGroup);
        }

        normalized.sort(
                Comparator.comparing(group -> String.join("\u0000", group))
        );

        return normalized;
    }

    public static void runTest(String testName, double actual, double expected) {
        double delta = 0.000001;
        boolean passed = Math.abs(actual - expected) < delta;

        System.out.println(
                testName
                        + " | ожидалось: " + expected
                        + ", получено: " + actual
                        + " -> " + (passed ? "OK" : "FAIL")
        );
    }
}