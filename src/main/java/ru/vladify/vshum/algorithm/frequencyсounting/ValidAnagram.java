package ru.vladify.vshum.algorithm.frequencyсounting;

import ru.vladify.vshum.algorithm.Utils;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        // Твоё решение

        return false;
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
