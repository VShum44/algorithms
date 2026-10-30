package ru.vladify.vshum.leetcode.task125;

public class Solution {

    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int tail = cleaned.length() - 1;
        int start = 0;
        while (start <= tail){
            if(cleaned.charAt(start++) != cleaned.charAt(tail--)){
                return false;
            }
        }
        return true;
    }
}
