package ru.vladify.vshum.algorithm.frequencyсounting;

import ru.vladify.vshum.algorithm.Utils;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    //Решение снизу
    public static boolean isAnagram2(String s, String t) {
        return false;
    }


    public static void main(String[] args) {
        Utils.runTest(
                "Анаграмма",
                isAnagram("anagram", "nagaram"),
                true
        );

        Utils.runTest(
                "Разные буквы",
                isAnagram("rat", "car"),
                false
        );

        Utils.runTest(
                "Разная длина",
                isAnagram("ab", "a"),
                false
        );

        Utils.runTest(
                "Одинаковые строки",
                isAnagram("abc", "abc"),
                true
        );

        Utils.runTest(
                "Одна одинаковая буква",
                isAnagram("a", "a"),
                true
        );

        Utils.runTest(
                "Одна разная буква",
                isAnagram("a", "b"),
                false
        );

        Utils.runTest(
                "Повторяющиеся буквы — анаграмма",
                isAnagram("aabbc", "bacab"),
                true
        );

        Utils.runTest(
                "Одинаковый набор букв, разное количество",
                isAnagram("aabb", "abbb"),
                false
        );

        Utils.runTest(
                "Обратный порядок",
                isAnagram("abcd", "dcba"),
                true
        );

        Utils.runTest(
                "Крайние буквы алфавита",
                isAnagram("aazz", "zaza"),
                true
        );
    }
//    public static boolean isAnagramSolution(String s, String t) {
//
//        // Твоё решение
//        if(s.length() != t.length()){ return false; }
//        Map<Character, Integer> word1Map = new HashMap<>();
//        Map<Character, Integer> word2Map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            word1Map.computeIfPresent(s.charAt(i), (c, n) -> ++n);
//            word1Map.putIfAbsent(s.charAt(i), 1);
//
//            word2Map.computeIfPresent(t.charAt(i), (c, n) -> ++n);
//            word2Map.putIfAbsent(t.charAt(i), 1);
//
//        }
//        return word1Map.equals(word2Map);
//    }


    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){ return false; }
        Map<Character, Integer> wordsAggregation = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            wordsAggregation.put(sChar, wordsAggregation.getOrDefault(sChar, 0) + 1);
            wordsAggregation.put(tChar, wordsAggregation.getOrDefault(tChar, 0) - 1);
        }

        for (int count : wordsAggregation.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
