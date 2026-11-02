package ru.vladify.vshum.algorithm.frequencyсounting;

import ru.vladify.vshum.algorithm.Utils;

/*
Дан массив целых чисел nums и положительное число k.

Верни новый массив, оставив каждое число не более k раз. Сохраняй первые допустимые вхождения и их исходный порядок.

Исходный массив менять не нужно.

nums = [1, 2, 1, 3, 1, 2], k = 2
Результат: [1, 2, 1, 3, 2]

nums = [4, 4, 4, 4], k = 1
Результат: [4]

nums = [3, 1, 3, 2, 1], k = 1
Результат: [3, 1, 2]

nums = [], k = 2
Результат: []

Важно: считаем все вхождения числа, а не только повторы подряд. Числа, встретившиеся больше k раз, не удаляем целиком — сохраняем первые k вхождений.

Ограничения:

0 ≤ nums.length ≤ 100_000;
k ≥ 1;
числа могут быть отрицательными;
null не приходит.
 */

public class LimitOccurrences {

    public static int[] limitOccurrences(int[] nums, int k) {

        return new int[0];
    }

    public static void main(String[] args) {
        Utils.runTest(
                "Повторы не подряд",
                limitOccurrences(new int[]{1, 2, 1, 3, 1, 2}, 2),
                new int[]{1, 2, 1, 3, 2}
        );

        Utils.runTest(
                "Оставить одно вхождение",
                limitOccurrences(new int[]{3, 1, 3, 2, 1}, 1),
                new int[]{3, 1, 2}
        );

        Utils.runTest(
                "Все одинаковые",
                limitOccurrences(new int[]{4, 4, 4, 4}, 2),
                new int[]{4, 4}
        );

        Utils.runTest(
                "Без удалений",
                limitOccurrences(new int[]{1, 2, 1}, 3),
                new int[]{1, 2, 1}
        );

        Utils.runTest(
                "Отрицательные числа и ноль",
                limitOccurrences(new int[]{-1, 0, -1, 0, -1}, 2),
                new int[]{-1, 0, -1, 0}
        );

        Utils.runTest(
                "Один элемент",
                limitOccurrences(new int[]{7}, 1),
                new int[]{7}
        );

        Utils.runTest(
                "Пустой массив",
                limitOccurrences(new int[]{}, 2),
                new int[]{}
        );
    }
}
