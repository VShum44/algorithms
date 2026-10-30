package ru.vladify.vshum.algorithm.twopointers;

import ru.vladify.vshum.algorithm.Utils;

/*
Дан массив numbers и число target.
Найди два элемента, сумма которых равна target, и верни их позиции.
 */
public class TwoSumSorted {

    public static int[] twoSumSorted(int[] numbers, int target) {
        int beginIndex = 0;
        int endIndex = numbers.length - 1;

        while (beginIndex < endIndex) {

            int sum = numbers[beginIndex] + numbers[endIndex];

            if (sum == target){
                return new int[]{beginIndex, endIndex};
            }else if (sum < target) {
                beginIndex++;
            } else {
                endIndex--;
            }
        }

        throw new IllegalArgumentException("Нет подходящих чисел в массиве");
    }

    public static void main(String[] args) {
        Utils.runTest(
                "Базовый пример",
                twoSumSorted(new int[]{2, 7, 11, 15}, 9),
                new int[]{0, 1}
        );

        Utils.runTest(
                "Элементы по краям",
                twoSumSorted(new int[]{2, 3, 4}, 6),
                new int[]{0, 2}
        );

        Utils.runTest(
                "Отрицательное число",
                twoSumSorted(new int[]{-1, 0}, -1),
                new int[]{0, 1}
        );

        Utils.runTest(
                "Одинаковые значения",
                twoSumSorted(new int[]{1, 1, 3, 5}, 2),
                new int[]{0, 1}
        );

        Utils.runTest(
                "Пара внутри массива",
                twoSumSorted(new int[]{1, 2, 4, 7, 11}, 9),
                new int[]{1, 3}
        );

        Utils.runTest(
                "Отрицательные числа",
                twoSumSorted(new int[]{-9, -5, -3, 0, 4}, -8),
                new int[]{1, 2}
        );
    }
}
