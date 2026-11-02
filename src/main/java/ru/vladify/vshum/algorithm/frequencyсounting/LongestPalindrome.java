package ru.vladify.vshum.algorithm.frequencyсounting;

import ru.vladify.vshum.algorithm.Utils;



/*
Дана строка s. Найди максимальную длину палиндрома, который можно собрать из её символов.

Символы можно переставлять.
Необязательно использовать все символы.
Каждый символ можно использовать не чаще, чем он встречается во входной строке.
Регистр важен: 'A' и 'a' — разные символы.
Строка содержит только a–z и A–Z.
Пустая строка допустима, null не приходит.
Палиндром одинаково читается слева направо и справа налево.

"abccccdd" → 7
Можно собрать "dccaccd".
Одна буква b останется неиспользованной.

"abc" → 1
Можно взять любую одну букву.

"aabb" → 4
Можно собрать "abba".

"Aa" → 1
Это разные символы, поэтому "Aa" не палиндром.

Важно: это не поиск подстроки-палиндрома.
Здесь разрешена перестановка символов. Возвращаем только длину, а не сам палиндром.
 */

public class LongestPalindrome {

    public static int longestPalindrome(String s) {

        return 0;
    }

    public static void main(String[] args) {
        Utils.runTest(
                "Базовый пример",
                longestPalindrome("abccccdd"),
                7
        );

        Utils.runTest(
                "Пустая строка",
                longestPalindrome(""),
                0
        );

        Utils.runTest(
                "Один символ",
                longestPalindrome("a"),
                1
        );

        Utils.runTest(
                "Все символы разные",
                longestPalindrome("abc"),
                1
        );

        Utils.runTest(
                "Все символы одинаковые",
                longestPalindrome("aaaa"),
                4
        );

        Utils.runTest(
                "Можно использовать все символы",
                longestPalindrome("aabbcc"),
                6
        );

        Utils.runTest(
                "Несколько нечётных частот",
                longestPalindrome("aaabbbcccddd"),
                9
        );

        Utils.runTest(
                "Регистр имеет значение",
                longestPalindrome("Aa"),
                1
        );

        Utils.runTest(
                "Парные символы разных регистров",
                longestPalindrome("AAaa"),
                4
        );
    }

//    public static int longestPalindrome(String s) {
//        int result = 0;
//        boolean plusOne = false;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        for (Integer charCount : map.values()) {
//            if(charCount % 2 == 0){ result += charCount; }
//            if(charCount > 2 && charCount % 2 != 0) {
//                result += charCount - 1;
//                plusOne = true;
//            }
//            if (charCount == 1){
//                plusOne = true;
//            }
//        }
//        return plusOne ? result + 1 : result;
//    }

}
