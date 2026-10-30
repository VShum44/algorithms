package ru.vladify.vshum.algorithm;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {return false;}

        Map<Character, Integer> wordMap = new HashMap<>();
        Map<Character, Integer> anagramMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            char sChar = s.charAt(i);
            wordMap.putIfAbsent(sChar, 0);
            wordMap.computeIfPresent(sChar, (c, n) -> n + 1);

            char tChar = t.charAt(i);
            anagramMap.putIfAbsent(tChar, 0);
            anagramMap.computeIfPresent(tChar, (c, n) -> n + 1);
        }

        return wordMap.equals(anagramMap);
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        Utils.runTest(s1, t1, isAnagram(s1, t1), true);

        String s2 = "rat";
        String t2 = "car";
        Utils.runTest(s2, t2, isAnagram(s2, t2), false);

        String s3 = "aacc";
        String t3 = "ccac";
        Utils.runTest(s3, t3, isAnagram(s3, t3), false);

        String s4 = "";
        String t4 = "";
        Utils.runTest(s4, t4, isAnagram(s4, t4), true);

        String s5 = "listen";
        String t5 = "silent";
        Utils.runTest(s5, t5, isAnagram(s5, t5), true);
    }
}
