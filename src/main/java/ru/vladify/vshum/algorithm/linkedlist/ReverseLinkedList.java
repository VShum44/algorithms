package ru.vladify.vshum.algorithm.linkedlist;

import ru.vladify.vshum.algorithm.Utils;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        // Твоё решение.
        throw new UnsupportedOperationException("Пока не реализовано");
    }

    public static void main(String[] args) {
        runTest("Пустой список", new int[]{});
        runTest("Один узел", new int[]{7});
        runTest("Два узла", new int[]{1, 2});
        runTest("Три узла", new int[]{1, 2, 3});
        runTest("Пять узлов", new int[]{1, 2, 3, 4, 5});

        runTest("Повторяющиеся значения", new int[]{1, 2, 1, 2});
        runTest("Все значения одинаковые", new int[]{5, 5, 5});
        runTest("Ноль и отрицательные", new int[]{0, -1, -2, 3});
        runTest("Крайние значения int",
                new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE});
    }

    private static void runTest(String testName, int[] input) {
        // Сохраняем ссылки на узлы в исходном порядке.
        ListNode[] originalNodes = new ListNode[input.length];

        for (int i = 0; i < input.length; i++) {
            originalNodes[i] = new ListNode(input[i]);

            if (i > 0) {
                originalNodes[i - 1].next = originalNodes[i];
            }
        }

        ListNode head = input.length == 0 ? null : originalNodes[0];

        String description = testName
                + " | вход: " + java.util.Arrays.toString(input);

        try {
            ListNode actualHead = reverseList(head);

            int[] expected = new int[input.length];
            int[] actual = new int[input.length];

            ListNode current = actualHead;

            for (int i = 0; i < input.length; i++) {
                int originalIndex = input.length - 1 - i;
                expected[i] = input[originalIndex];

                if (current == null) {
                    System.out.println(
                            description + " -> FAIL: список короче ожидаемого"
                    );
                    return;
                }

                // Сравниваем именно ссылки, а не значения.
                if (current != originalNodes[originalIndex]) {
                    System.out.println(
                            description
                                    + " -> FAIL: неверный узел на позиции " + i
                                    + "; нужны исходные узлы в обратном порядке"
                    );
                    return;
                }

                actual[i] = current.val;
                current = current.next;
            }

            // Не обходим список бесконечно при наличии цикла.
            if (current != null) {
                System.out.println(
                        description + " -> FAIL: лишние узлы или цикл"
                );
                return;
            }

            Utils.runTest(description, actual, expected);
        } catch (Exception e) {
            System.out.println(description + " -> ERROR: " + e);
        }
    }
}
