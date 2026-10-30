package ru.vladify.vshum.algorithm;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if(!seen.add(num)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Utils.runTest(
                "Дубликат в массиве",
                containsDuplicate(new int[]{1, 2, 3, 1}),
                true
        );

        Utils.runTest(
                "Нет дубликатов",
                containsDuplicate(new int[]{1, 2, 3, 4}),
                false
        );

        Utils.runTest(
                "Одинаковые значения",
                containsDuplicate(new int[]{3, 3}),
                true
        );

        Utils.runTest(
                "Пустой массив",
                containsDuplicate(new int[]{}),
                false
        );

        Utils.runTest(
                "Один элемент",
                containsDuplicate(new int[]{0}),
                false
        );

        Utils.runTest(
                "Отрицательные значения",
                containsDuplicate(new int[]{-1, 0, -1}),
                true
        );
    }
}
