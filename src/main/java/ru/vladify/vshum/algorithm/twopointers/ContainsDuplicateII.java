package ru.vladify.vshum.algorithm.twopointers;

import ru.vladify.vshum.algorithm.Utils;
/*
Дан массив nums и число k.
Верни true, если в массиве есть два разных индекса i и j такие,
что nums[i] == nums[j] и |i - j| <= k. Иначе — false.
 */
public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // Твоё решение
        int beginIndex;

        return false;
    }

    public static void main(String[] args) {
        Utils.runTest(
                "Базовый пример",
                containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3),
                true
        );

        Utils.runTest(
                "Дубликат рядом",
                containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1),
                true
        );

        Utils.runTest(
                "Дубликаты слишком далеко",
                containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2),
                false
        );

        Utils.runTest(
                "Два элемента",
                containsNearbyDuplicate(new int[]{99, 99}, 2),
                true
        );

        Utils.runTest(
                "Нет дубликатов",
                containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5}, 1),
                false
        );

        Utils.runTest(
                "k равно нулю",
                containsNearbyDuplicate(new int[]{1, 2, 1}, 0),
                false
        );
    }
}
