package ru.vladify.vshum.leetcode.task206;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        runTest("Пример 1",
                new int[]{1, 2, 3, 4, 5},
                new int[]{5, 4, 3, 2, 1});

        runTest("Пример 2",
                new int[]{1, 2},
                new int[]{2, 1});

        runTest("Пустой список",
                new int[]{},
                new int[]{});

        runTest("Один элемент",
                new int[]{42},
                new int[]{42});

        runTest("Отрицательные числа и ноль",
                new int[]{-3, -1, 0, 2},
                new int[]{2, 0, -1, -3});

        runTest("Повторяющиеся значения",
                new int[]{1, 2, 2, 3},
                new int[]{3, 2, 2, 1});

        runTest("Одинаковые значения",
                new int[]{7, 7, 7},
                new int[]{7, 7, 7});
    }

    private static void runTest(String name, int[] input,int[] expected) {
        System.out.println("=== " + name + " ===");
        System.out.println("Вход:     " + Arrays.toString(input));
        System.out.println("Ожидается: " + Arrays.toString(expected));

        ListNode head = createList(input);

        try {
            ListNode result = new Solution().reverseList(head);
            assertListEquals(expected, result);
            System.out.println("OK");
        } catch (UnsupportedOperationException e) {
            System.out.println("НЕ РЕАЛИЗОВАНО: " + e.getMessage());
        } catch (AssertionError e) {
            System.out.println("FAIL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ОШИБКА: " + e);
        }

        System.out.println();
    }

    private static ListNode createList(int[] values) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }

        return dummy.next;
    }

    private static void assertListEquals(
            int[] expected,
            ListNode actual
    ) {
        ListNode current = actual;

        for (int i = 0; i < expected.length; i++) {
            if (current == null) {
                throw new AssertionError(
                        "Список закончился раньше: позиция " + i
                );
            }

            if (current.val != expected[i]) {
                throw new AssertionError(
                        "Позиция " + i
                                + ": ожидалось " + expected[i]
                                + ", получено " + current.val
                );
            }

            current = current.next;
        }

        if (current != null) {
            throw new AssertionError(
                    "В списке есть лишние элементы или цикл"
            );
        }
    }
}
