package ru.vladify.vshum.algorithm.twopointers;

import ru.vladify.vshum.algorithm.Utils;

/*
Дан массив целых чисел nums и число k.
Найди максимальное среднее значение среди всех непрерывных подмассивов длины k.
 */
public class MaximumAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {
        if (k > nums.length) {
            throw new IllegalArgumentException("Длинны массива недостаточно");
        }

        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        long maxSum = windowSum;

        for (int begin = 1; begin <= nums.length - k; begin++) {
            windowSum += nums[begin + k - 1] - nums[begin -1];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        Utils.runTest(
                "Базовый пример",
                findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4),
                12.75
        );

        Utils.runTest(
                "Окно из одного элемента",
                findMaxAverage(new int[]{5}, 1),
                5.0
        );

        Utils.runTest(
                "Все окна длины один",
                findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1),
                4.0
        );

        Utils.runTest(
                "Окно равно длине массива",
                findMaxAverage(new int[]{1, 2, 3, 4}, 4),
                2.5
        );

        Utils.runTest(
                "Отрицательные числа",
                findMaxAverage(new int[]{-1, -12, -5, -6, -50, -3}, 2),
                -5.5
        );

        Utils.runTest(
                "Максимальное окно в конце",
                findMaxAverage(new int[]{-10, -5, 8, 9, 10}, 3),
                9.0
        );

        Utils.runTest(
                "Нули и отрицательные числа",
                findMaxAverage(new int[]{0, -1, 0, -2, 5}, 2),
                1.5
        );
    }
}
