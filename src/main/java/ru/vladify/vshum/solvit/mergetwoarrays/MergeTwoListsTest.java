package ru.vladify.vshum.solvit.mergetwoarrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class MergeTwoListsTest {

    private static class TestCase {
        final String name;
        final int[] list1;
        final int[] list2;
        final int[] expected;

        TestCase(String name, int[] list1, int[] list2, int[] expected) {
            this.name = name;
            this.list1 = list1;
            this.list2 = list2;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        TestCase[] tests = {
                new TestCase("Пример 1",
                        new int[]{1, 2, 4},
                        new int[]{1, 3, 4},
                        new int[]{1, 1, 2, 3, 4, 4}),

                new TestCase("Оба списка пустые",
                        new int[]{},
                        new int[]{},
                        new int[]{}),

                new TestCase("Первый пустой",
                        new int[]{},
                        new int[]{0},
                        new int[]{0}),

                new TestCase("Второй пустой",
                        new int[]{0},
                        new int[]{},
                        new int[]{0}),

                new TestCase("По одному узлу",
                        new int[]{1},
                        new int[]{2},
                        new int[]{1, 2}),

                new TestCase("Второй узел меньше первого",
                        new int[]{2},
                        new int[]{1},
                        new int[]{1, 2}),

                new TestCase("Одинаковые одиночные значения",
                        new int[]{5},
                        new int[]{5},
                        new int[]{5, 5}),

                new TestCase("Первый список целиком меньше",
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{1, 2, 3, 4, 5, 6}),

                new TestCase("Второй список целиком меньше",
                        new int[]{4, 5, 6},
                        new int[]{1, 2, 3},
                        new int[]{1, 2, 3, 4, 5, 6}),

                new TestCase("Чередующиеся значения",
                        new int[]{1, 3, 5},
                        new int[]{2, 4, 6},
                        new int[]{1, 2, 3, 4, 5, 6}),

                new TestCase("Повторяющиеся значения",
                        new int[]{1, 1, 3},
                        new int[]{1, 2, 3, 3},
                        new int[]{1, 1, 1, 2, 3, 3, 3}),

                new TestCase("Все значения одинаковые",
                        new int[]{0, 0},
                        new int[]{0, 0, 0},
                        new int[]{0, 0, 0, 0, 0}),

                new TestCase("Отрицательные значения",
                        new int[]{-10, -5, -1},
                        new int[]{-8, -3},
                        new int[]{-10, -8, -5, -3, -1}),

                new TestCase("Отрицательные, ноль и положительные",
                        new int[]{-5, 0, 4},
                        new int[]{-3, 0, 7},
                        new int[]{-5, -3, 0, 0, 4, 7}),

                new TestCase("Граничные значения",
                        new int[]{-100, 100},
                        new int[]{-100, 0, 100},
                        new int[]{-100, -100, 0, 100, 100}),

                new TestCase("Списки разной длины",
                        new int[]{3},
                        new int[]{-2, 0, 1, 4, 8},
                        new int[]{-2, 0, 1, 3, 4, 8}),

                new TestCase("50 узлов суммарно",
                        range(-25, -1),
                        range(0, 24),
                        range(-25, 24)),

                new TestCase("50 узлов, второй список пустой",
                        range(1, 50),
                        new int[]{},
                        range(1, 50))
        };

        int passed = 0;
        int failed = 0;
        int errors = 0;

        for (int i = 0; i < tests.length; i++) {
            TestCase test = tests[i];

            ListNode list1 = buildList(test.list1);
            ListNode list2 = buildList(test.list2);

            // Запоминаем исходные узлы до вызова решения:
            // решение может изменить их связи.
            Set<ListNode> originalNodes = identitySet();
            collectNodes(list1, originalNodes);
            collectNodes(list2, originalNodes);

            try {
                ListNode actual =
                        new Solution().mergeTwoLists(list1, list2);

                String problem = validate(
                        actual, test.expected, originalNodes
                );

                if (problem == null) {
                    passed++;
                    System.out.printf(
                            "PASS [%02d] %s%n", i + 1, test.name
                    );
                } else {
                    failed++;
                    System.out.printf(
                            "FAIL [%02d] %s | %s | expected=%s%n",
                            i + 1, test.name, problem,
                            Arrays.toString(test.expected)
                    );
                }
            } catch (Exception e) {
                errors++;
                System.out.printf(
                        "ERROR [%02d] %s | %s: %s%n",
                        i + 1, test.name,
                        e.getClass().getSimpleName(), e.getMessage()
                );
            }
        }

        System.out.printf(
                "%nВсего: %d | Пройдено: %d | Ошибок ответа: %d | Исключений: %d%n",
                tests.length, passed, failed, errors
        );

        if (failed > 0 || errors > 0) {
            throw new AssertionError("Не все тесты пройдены");
        }
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }

        return dummy.next;
    }

    private static Set<ListNode> identitySet() {
        // Сравнение по ссылкам, а не по значениям узлов.
        return Collections.newSetFromMap(
                new IdentityHashMap<ListNode, Boolean>()
        );
    }

    private static void collectNodes(
            ListNode head, Set<ListNode> nodes
    ) {
        for (ListNode node = head; node != null; node = node.next) {
            nodes.add(node);
        }
    }

    private static String validate(
            ListNode head,
            int[] expected,
            Set<ListNode> originalNodes
    ) {
        Set<ListNode> visited = identitySet();
        int index = 0;

        for (ListNode node = head; node != null; node = node.next) {
            if (!visited.add(node)) {
                return "В результате обнаружен цикл";
            }

            if (!originalNodes.contains(node)) {
                return "Результат содержит новый, не исходный узел";
            }

            if (index >= expected.length) {
                return "В результате слишком много узлов";
            }

            if (node.val != expected[index]) {
                return "Позиция " + index
                        + ": expected=" + expected[index]
                        + ", actual=" + node.val;
            }

            index++;
        }

        if (index != expected.length) {
            return "Неверное число узлов: expected="
                    + expected.length + ", actual=" + index;
        }

        if (visited.size() != originalNodes.size()) {
            return "Не все исходные узлы включены в результат";
        }

        return null;
    }

    // Генератор тестовых данных: значения от from до to включительно.
    private static int[] range(int from, int to) {
        int[] values = new int[to - from + 1];

        for (int i = 0; i < values.length; i++) {
            values[i] = from + i;
        }

        return values;
    }
}