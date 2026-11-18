package ru.vladify.vshum.algorithm.binarysearch;

import ru.vladify.vshum.algorithm.Utils;

/*
Дан массив nums, отсортированный по возрастанию, и число target.
Верни индекс target или -1, если такого числа нет.

Условия:

Все элементы уникальны.
nums != null, массив может быть пустым.
Целевая сложность: O(log n) времени и O(1) дополнительной памяти.
Не используй готовые методы поиска.
 */
public class BinarySearch {

    public static int search(int[] nums, int target) {
        // Напиши своё решение здесь.
        if(nums.length < 1) return -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
           int  middleIndex = (right + left) / 2;
            int num = nums[middleIndex];
            if(num == target){
                return middleIndex;
            }else if(num < target){
                left = middleIndex + 1;
            }else {
                right = middleIndex - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        runTest("Пустой массив",
                new int[]{}, 5, -1);

        runTest("Один элемент — найден",
                new int[]{5}, 5, 0);
        runTest("Один элемент — не найден",
                new int[]{5}, 3, -1);

        runTest("Два элемента — первый",
                new int[]{2, 8}, 2, 0);
        runTest("Два элемента — второй",
                new int[]{2, 8}, 8, 1);
        runTest("Два элемента — число между ними",
                new int[]{2, 8}, 5, -1);

        runTest("Нечётная длина — середина",
                new int[]{1, 3, 5, 7, 9}, 5, 2);
        runTest("Чётная длина — левее середины",
                new int[]{1, 3, 5, 7, 9, 11}, 5, 2);
        runTest("Чётная длина — правее середины",
                new int[]{1, 3, 5, 7, 9, 11}, 7, 3);

        runTest("Первый элемент",
                new int[]{-10, -3, 0, 4, 9}, -10, 0);
        runTest("Последний элемент",
                new int[]{-10, -3, 0, 4, 9}, 9, 4);
        runTest("Ноль",
                new int[]{-10, -3, 0, 4, 9}, 0, 2);

        runTest("Меньше минимального",
                new int[]{1, 3, 5, 7}, -1, -1);
        runTest("Больше максимального",
                new int[]{1, 3, 5, 7}, 10, -1);
        runTest("Отсутствует внутри диапазона",
                new int[]{1, 3, 5, 7}, 4, -1);

        runTest("Только отрицательные числа",
                new int[]{-20, -15, -8, -3}, -8, 2);
        runTest("Крайние значения int",
                new int[]{Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE},
                Integer.MAX_VALUE, 3);
    }

    private static void runTest(
            String testName,
            int[] nums,
            int target,
            int expected
    ) {
        String description = testName
                + " | массив: " + java.util.Arrays.toString(nums)
                + ", target: " + target;

        try {
            int actual = search(nums, target);

            // Используем существующую перегрузку Utils для int[].
            Utils.runTest(
                    description,
                    new int[]{actual},
                    new int[]{expected}
            );
        } catch (Exception e) {
            System.out.println(
                    description
                            + " | ожидалось: " + expected
                            + " -> ERROR: " + e
            );
        }
    }
}