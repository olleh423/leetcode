package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-01-2021
 */
public class LongestSubstringWithAtLeastKRepeating {

    public static void main(String[] args) {

        LongestSubstringWithAtLeastKRepeating obj = new LongestSubstringWithAtLeastKRepeating();

        String s = "ababbc";
        int k = 2;
        System.out.println(obj.longestSubstring(s, k));
    }

    public int longestSubstring(String s, int k) {

        if(s == null)
            return 0;

        int n = s.length();
        if(k == 1)
            return n;

        int[] freq = new int[26];
        for(int i=0 ; i<n ; i++) {
            freq[s.charAt(i)-'a']++;
        }

        int len = 0;
        while(len < n && freq[s.charAt(len)-'a'] >= k)
            len++;

        if(len == n)
            return n;

        int left = longestSubstring(s.substring(0, len), k);
        while(len < n && freq[s.charAt(len)-'a'] < k)
            len++;
        int right = longestSubstring(s.substring(len), k);

        return Math.max(left, right);
    }
}
