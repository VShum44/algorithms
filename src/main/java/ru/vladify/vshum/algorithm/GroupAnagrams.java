package ru.vladify.vshum.algorithm;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grouped = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortesStr = new String(charArray);

            grouped.computeIfAbsent(sortesStr, s -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(grouped.values());
    }

    public static void main(String[] args) {
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Utils.runTest(
                "Базовый пример",
                input1,
                groupAnagrams(input1),
                Arrays.asList(
                        Arrays.asList("eat", "tea", "ate"),
                        Arrays.asList("tan", "nat"),
                        Arrays.asList("bat")
                )
        );

        String[] input2 = {"", ""};
        Utils.runTest(
                "Пустые строки",
                input2,
                groupAnagrams(input2),
                Arrays.asList(Arrays.asList("", ""))
        );

        String[] input3 = {};
        Utils.runTest(
                "Пустой массив",
                input3,
                groupAnagrams(input3),
                Collections.emptyList()
        );

        String[] input4 = {"abc", "abc", "bca"};
        Utils.runTest(
                "Повторяющиеся слова сохраняются",
                input4,
                groupAnagrams(input4),
                Arrays.asList(
                        Arrays.asList("abc", "abc", "bca")
                )
        );

        String[] input5 = {"cat", "dog", "bird"};
        Utils.runTest(
                "Нет анаграмм",
                input5,
                groupAnagrams(input5),
                Arrays.asList(
                        Arrays.asList("cat"),
                        Arrays.asList("dog"),
                        Arrays.asList("bird")
                )
        );

        String[] input6 = {"a", "aa", "aaa"};
        Utils.runTest(
                "Разное количество одинаковых букв",
                input6,
                groupAnagrams(input6),
                Arrays.asList(
                        Arrays.asList("a"),
                        Arrays.asList("aa"),
                        Arrays.asList("aaa")
                )
        );

        String[] input7 = {"aacc", "ccac", "caca", "accc"};
        Utils.runTest(
                "Одинаковые буквы с разными частотами",
                input7,
                groupAnagrams(input7),
                Arrays.asList(
                        Arrays.asList("aacc", "caca"),
                        Arrays.asList("ccac", "accc")
                )
        );

        String[] input8 = {"listen"};
        Utils.runTest(
                "Одно слово",
                input8,
                groupAnagrams(input8),
                Arrays.asList(
                        Arrays.asList("listen")
                )
        );

        String[] input9 = {"", "a", "", "a", "b"};
        Utils.runTest(
                "Пустые строки вместе с буквами",
                input9,
                groupAnagrams(input9),
                Arrays.asList(
                        Arrays.asList("", ""),
                        Arrays.asList("a", "a"),
                        Arrays.asList("b")
                )
        );

        String[] input10 = {"ab", "ba", "abc", "cab", "a", "b"};
        Utils.runTest(
                "Слова разной длины",
                input10,
                groupAnagrams(input10),
                Arrays.asList(
                        Arrays.asList("ab", "ba"),
                        Arrays.asList("abc", "cab"),
                        Arrays.asList("a"),
                        Arrays.asList("b")
                )
        );

        String[] input11 = {"abc", "bca", "cab", "acb", "bac", "cba"};
        Utils.runTest(
                "Все слова — анаграммы",
                input11,
                groupAnagrams(input11),
                Arrays.asList(
                        Arrays.asList("abc", "bca", "cab", "acb", "bac", "cba")
                )
        );
    }
}
