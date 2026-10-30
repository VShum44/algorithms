package ru.vladify.vshum.algorithm.hashing;

import java.util.Arrays;
import java.util.HashMap;

/*
Дан массив целых чисел nums и целое число target.
Верни индексы двух разных элементов, сумма которых равна target.
 */
public class TwoSum {

    // O(n в квадрате)
//    public static int[] twoSum(int[] nums, int target) {
//        // Напиши своё решение здесь.
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if( nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//
//        return new int[0];
//    }

        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> watched = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int needed  = target - num;
                if(watched.containsKey(needed)){
                    return new int[] {watched.get(needed ), i};
                }
                else {
                    watched.put(num, i);
                }
            }

        return new int[0];
    }

    public static void main(String[] args) {
        runTest(new int[]{2, 7, 11, 15}, 9);
        runTest(new int[]{3, 2, 4}, 6);
        runTest(new int[]{3, 3}, 6);
        runTest(new int[]{-3, 4, 3, 90}, 0);
        runTest(new int[]{0, 4, 3, 0}, 0);
        runTest(new int[]{1, 5, 8, 12}, 20);
    }

    private static void runTest(int[] nums, int target) {
        // Сохраняем исходные данные на случай, если решение меняет массив.
        int[] original = nums.clone();

        System.out.println("Массив: " + Arrays.toString(original));
        System.out.println("Target: " + target);

        try {
            int[] result = twoSum(nums, target);

            System.out.println("Твой ответ: " + Arrays.toString(result));

            String error = validate(original, target, result);
            System.out.println(error == null
                    ? "Результат: OK"
                    : "Результат: FAIL — " + error);
        } catch (Exception e) {
            System.out.println("Ошибка выполнения: " + e);
        }

        System.out.println("--------------------------------");
    }

    private static String validate(int[] nums, int target, int[] result) {
        if (result == null || result.length != 2) {
            return "нужно вернуть массив из двух индексов";
        }

        int first = result[0];
        int second = result[1];

        if (first < 0 || first >= nums.length
                || second < 0 || second >= nums.length) {
            return "индекс за пределами массива";
        }

        if (first == second) {
            return "нельзя использовать один элемент дважды";
        }

        if ((long) nums[first] + nums[second] != target) {
            return "сумма выбранных элементов не равна target";
        }

        return null;
    }

}
