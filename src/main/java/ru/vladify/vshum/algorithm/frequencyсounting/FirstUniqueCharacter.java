package ru.vladify.vshum.algorithm.frequencyсounting;

import ru.vladify.vshum.algorithm.Utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Нужно вернуть индекс первого символа,
встречающегося во всей строке ровно один раз, или -1, если такого нет.

"loveleetcode" → 2
"aabb"         → -1
"aA"           → 0
""             → -1

Только буквы a–z, A–Z; регистр важен, null не приходит.
 */
public class FirstUniqueCharacter {

    public static int firstUniqueChar(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(charFrequency.get(c) < 2) {
              return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Utils.runTest("Первый символ",
                firstUniqueChar("leetcode"), 0);

        Utils.runTest("Уникальный в середине",
                firstUniqueChar("loveleetcode"), 2);

        Utils.runTest("Все повторяются",
                firstUniqueChar("aabb"), -1);

        Utils.runTest("Разный регистр",
                firstUniqueChar("aA"), 0);

        Utils.runTest("Уникальный в конце",
                firstUniqueChar("aabbc"), 4);

        Utils.runTest("Первый из нескольких уникальных",
                firstUniqueChar("aabbcd"), 4);

        Utils.runTest("Повторы не подряд",
                firstUniqueChar("abacb"), 3);

        Utils.runTest("Все символы уникальны",
                firstUniqueChar("xyz"), 0);

        Utils.runTest("Один символ",
                firstUniqueChar("z"), 0);

        Utils.runTest("Только одинаковые символы",
                firstUniqueChar("aaaa"), -1);

        Utils.runTest("Пустая строка",
                firstUniqueChar(""), -1);
    }

    //Решение сложное
//    public static int firstUniqueChar(String s) {
//        Map<Character, Integer> frequency = new HashMap<>();
//        Map<Character, Integer> indexes = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            Integer putedChar = frequency.put(c, frequency.getOrDefault(c, 0) + 1);
//            if (putedChar == null) {
//                indexes.put(c, i);
//            }
//            if(putedChar != null && indexes.containsKey(c)){
//                indexes.remove(c);
//            }
//        }
//        int result = 0;
//        if (!indexes.isEmpty()) {
//            result = indexes.values().stream().findAny().get();
//        }
//        for (Integer value : indexes.values()) {
//            result = Math.min(value, result);
//        }
//        return indexes.isEmpty() ? -1 : result;
//    }

}
