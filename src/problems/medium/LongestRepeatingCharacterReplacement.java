package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 20-01-2021
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();

        String s = "abcbabfaghia";
        int k = 2;
        System.out.println(obj.characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {

        if(s == null)
            return 0;

        int N = s.length();
        int[] chars = new int[26];
        int start = 0, end = 0;
        int maxLen = 0;

        while(end < N) {

            char current = s.charAt(end);
            chars[current - 'A']++;

            int maxFreq = getMax(chars);
            int subLen = end - start + 1;

            if(subLen - maxFreq <= k) {
                maxLen = Math.max(subLen, maxLen);
                end++;
            }
            else {
                maxLen = Math.max(subLen-1, maxLen);
                chars[current - 'A']--;
                chars[s.charAt(start++) - 'A']--;
            }
        }

        return maxLen;
    }

    private int getMax(int[] chars) {
        int max = chars[0];
        for(int element : chars)
            max = Math.max(max, element);
        return max;
    }
}
