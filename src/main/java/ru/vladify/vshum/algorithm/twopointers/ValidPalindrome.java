package ru.vladify.vshum.algorithm.twopointers;

/*
Дана строка s.

Верни true, если строка является палиндромом:
- игнорируй регистр;
- учитывай только буквы и цифры;
- остальные символы пропускай.

Условия:
- s != null;
- строка содержит только ASCII-символы;
- пустая строка считается палиндромом.

Целевая сложность:
- время: O(n);
- дополнительная память: O(1).
 */

import ru.vladify.vshum.algorithm.Utils;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        int beginIndex = 0;
        int endIndex = s.length() - 1;

        while (beginIndex < endIndex) {
            char beginC = s.charAt(beginIndex);
            char endC = s.charAt(endIndex);
            if (!Character.isLetterOrDigit(beginC)) {
                beginIndex++;
            } else if (!Character.isLetterOrDigit(endC)) {
                endIndex--;
            } else if (Character.toLowerCase(beginC) != Character.toLowerCase(endC)) {
                return false;
            } else {
                beginIndex++;
                endIndex--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Базовые случаи.
        runTest("Пустая строка", "", true);
        runTest("Одна буква", "a", true);
        runTest("Одна цифра", "7", true);

        // Чётная и нечётная длина.
        runTest("Две одинаковые буквы", "aa", true);
        runTest("Две разные буквы", "ab", false);
        runTest("Нечётный палиндром", "racecar", true);
        runTest("Чётный палиндром", "abba", true);
        runTest("Не палиндром", "hello", false);
        runTest("Несовпадение ближе к центру", "abca", false);

        // Регистр.
        runTest("Разный регистр", "Aa", true);
        runTest("Смешанный регистр", "RaCeCaR", true);
        runTest("Регистр не исправляет несовпадение", "Ab", false);

        // Пропуск символов.
        runTest("Только пробелы", "   ", true);
        runTest("Только спецсимволы", ".,!?:;-_()", true);
        runTest("Буква между спецсимволами", ".,a!?", true);
        runTest("Символы по краям", "!!!abba???", true);
        runTest("Символы внутри", "a,b.a", true);
        runTest("Несимметричные разделители", "a...b,a", true);
        runTest("Табуляция и перенос строки", "\tA\n a\r", true);
        runTest("Разделители между разными буквами", "a.,b", false);

        // Цифры тоже нужно учитывать.
        runTest("Палиндром из цифр", "12321", true);
        runTest("Цифры — не палиндром", "1231", false);
        runTest("Буквы и цифры", "1a2A1", true);
        runTest("Цифры с разделителями", "12, 21", true);
        runTest("Цифру нельзя пропустить", "0P", false);
        runTest("Буква и цифра на краях", "a1", false);

        // Примеры из условия.
        runTest(
                "Фраза-палиндром",
                "A man, a plan, a canal: Panama",
                true
        );
        runTest(
                "Фраза — не палиндром",
                "race a car",
                false
        );
        runTest(
                "После удаления символов строка пустая",
                " ., ",
                true
        );
    }

    private static void runTest(
            String testName,
            String input,
            boolean expected
    ) {
        String description = testName + " | вход: \"" + escape(input) + "\"";

        try {
            boolean actual = isPalindrome(input);
            Utils.runTest(description, actual, expected);
        } catch (Exception e) {
            // Ошибка в одном тесте не мешает запуску остальных.
            System.out.println(
                    description
                            + " | ожидалось: " + expected
                            + " -> ERROR: " + e
            );
        }
    }

    private static String escape(String value) {
        // Делаем управляющие символы видимыми в консоли.
        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\t", "\\t")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

//    public static boolean isPalindrome(String s) {
//
//        if(s.length() <= 1){
//            return true;
//        }
//
//        String palindrome = s.toLowerCase().replace(" ", "").trim();
//
//        int beginIndex = 0;
//        int endIndex = palindrome.length() - 1;
//
//        while (beginIndex < endIndex){
//            if(palindrome.charAt(beginIndex) != palindrome.charAt(endIndex)){
//                return false;
//            }
//            beginIndex++;
//            endIndex--;
//        }

//        return true;
//    }


    /*
    Perfect variant
     */

//    public static boolean isPalindrome(String s) {
//
//        int beginIndex = 0;
//        int endIndex = s.length() - 1;
//
//        while (beginIndex < endIndex) {
//            char beginC = s.charAt(beginIndex);
//            char endC = s.charAt(endIndex);
//            if (!Character.isLetterOrDigit(beginC)) {
//                beginIndex++;
//            } else if (!Character.isLetterOrDigit(endC)) {
//                endIndex--;
//            } else if (Character.toLowerCase(beginC) != Character.toLowerCase(endC)) {
//                return false;
//            } else {
//                beginIndex++;
//                endIndex--;
//            }
//        }
//        return true;
//    }
}
