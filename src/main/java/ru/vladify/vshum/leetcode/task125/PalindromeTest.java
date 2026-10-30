package ru.vladify.vshum.leetcode.task125;

import java.util.Arrays;

public class PalindromeTest {

    private static class TestCase {
        final String name;
        final String input;
        final boolean expected;

        TestCase(String name, String input, boolean expected) {
            this.name = name;
            this.input = input;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TestCase[] tests = {
                // Примеры из условия
                new TestCase("Пример 1",
                        "A man, a plan, a canal: Panama", true),
                new TestCase("Пример 2",
                        "race a car", false),
                new TestCase("Пример 3",
                        " ", true),

                // Минимальная длина и отсутствие букв/цифр
                new TestCase("Одна буква", "a", true),
                new TestCase("Одна цифра", "7", true),
                new TestCase("Один знак", "!", true),
                new TestCase("Только знаки", ".,!?:;_-()[]{}", true),
                new TestCase("Только пробелы", "     ", true),

                // Длина и регистр
                new TestCase("Две одинаковые буквы", "aa", true),
                new TestCase("Две разные буквы", "ab", false),
                new TestCase("Разный регистр", "aA", true),
                new TestCase("Нечётная длина", "racecar", true),
                new TestCase("Чётная длина", "abba", true),
                new TestCase("Не палиндром", "abc", false),
                new TestCase("Различие в середине", "abca", false),

                // Игнорирование пробелов и знаков
                new TestCase("Знаки по краям", "!!Abba??", true),
                new TestCase("Знаки внутри", "a.,b : b; a", true),
                new TestCase("Одна значимая буква", "... A !!!", true),
                new TestCase("Фраза с апострофом", "No 'x' in Nixon", true),
                new TestCase("Фраза не палиндром", "hello, world!", false),

                // Цифры должны учитываться
                new TestCase("Цифровой палиндром", "12321", true),
                new TestCase("Разные цифры", "1231", false),
                new TestCase("Цифры и знаки", "1, 2: 2, 1", true),
                new TestCase("Буквы и цифры", "A1b1a", true),
                new TestCase("Цифра и буква", "0P", false),
                new TestCase("Цифра нарушает симметрию", "a1", false),
                new TestCase("Цифра между буквами", "a0A", true),

                // Максимальная длина: 200 000 символов
                new TestCase("Максимум: одинаковые буквы",
                        repeated('a', 200_000), true),
                new TestCase("Максимум: несовпадение краёв",
                        repeated('a', 199_999) + "b", false),
                new TestCase("Максимум: только пробелы",
                        repeated(' ', 200_000), true),
                new TestCase("Максимум: буквы на краях",
                        "A" + repeated(' ', 199_998) + "a", true)
        };

        int passed = 0;
        int failed = 0;
        int errors = 0;

        for (int i = 0; i < tests.length; i++) {
            TestCase test = tests[i];

            try {
                boolean actual = solution.isPalindrome(test.input);

                if (actual == test.expected) {
                    passed++;
                    System.out.printf(
                            "PASS [%02d] %s%n", i + 1, test.name
                    );
                } else {
                    failed++;
                    System.out.printf(
                            "FAIL [%02d] %s | expected=%s, actual=%s, input=%s%n",
                            i + 1, test.name, test.expected,
                            actual, preview(test.input)
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

    private static String repeated(char symbol, int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, symbol);
        return new String(chars);
    }

    private static String preview(String input) {
        if (input.length() <= 80) {
            return "\"" + input + "\"";
        }

        return "\"" + input.substring(0, 35)
                + "..."
                + input.substring(input.length() - 35)
                + "\" (length=" + input.length() + ")";
    }
}
