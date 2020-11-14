package problems.hard;

import java.util.*;

/*
 * Author : Vijay Sharma 12-11-2020
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {

        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(obj.minWindow(s, t));
    }

    public String minWindow(String s, String t) {

        if(s == null) return s;
        if(t == null || t.isEmpty()) return "";

        int[] chars = new int[128];
        for(char ch : t.toCharArray())
            chars[ch]++;

        int len = t.length();
        int left = 0, right = 0, minStart = 0, minLength = Integer.MAX_VALUE;

        while(right < s.length()) {

            if(--chars[s.charAt(right++)] >= 0)
                len--;

            while(len == 0) {

                if(right - left < minLength) {
                    minLength = right - left;
                    minStart = left;
                }

                if(++chars[s.charAt(left++)] > 0)
                    len++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
