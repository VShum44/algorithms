package ru.vladify.vshum.algorithm.twopointers;

import ru.vladify.vshum.algorithm.Utils;

/*
Перемести все нули в конец массива, сохранив порядок остальных элементов.
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        int numIndex = 0;
        while (numIndex < nums.length){
            int num = nums[numIndex];

            if (zeroIndex == -1 && num == 0){
                zeroIndex = numIndex;
            }

            if(num != 0 && zeroIndex > -1){
                nums[zeroIndex] = num;
                nums[numIndex] = 0;
                zeroIndex++;
            }

            numIndex++;
        }
    }

    public static void main(String[] args) {
        int[] input1 = {0, 1, 0, 3, 12};
        moveZeroes(input1);
        Utils.runTest(
                "Нули между числами",
                input1,
                new int[]{1, 3, 12, 0, 0}
        );

        int[] input2 = {0, 0, 1};
        moveZeroes(input2);
        Utils.runTest(
                "Нули в начале",
                input2,
                new int[]{1, 0, 0}
        );

        int[] input3 = {1, 2, 3};
        moveZeroes(input3);
        Utils.runTest(
                "Без нулей",
                input3,
                new int[]{1, 2, 3}
        );

        int[] input4 = {0, 0, 0};
        moveZeroes(input4);
        Utils.runTest(
                "Только нули",
                input4,
                new int[]{0, 0, 0}
        );

        int[] input5 = {0};
        moveZeroes(input5);
        Utils.runTest(
                "Один ноль",
                input5,
                new int[]{0}
        );

        int[] input6 = {0, -1, 0, -2, 3, 0};
        moveZeroes(input6);
        Utils.runTest(
                "Отрицательные числа и ноль в конце",
                input6,
                new int[]{-1, -2, 3, 0, 0, 0}
        );
    }
}
