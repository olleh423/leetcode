package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class LongestPalindrome {

    public static void main(String[] args) {

        LongestPalindrome obj = new LongestPalindrome();

        String s = "abccccdd";
        System.out.println(obj.longestPalindrome(s));
    }

    public int longestPalindrome(String s) {

        if(s == null || s.isEmpty())
            return 0;

        int[] chars = new int[123];
        for(int i=0 ; i<s.length() ; i++) {
            chars[s.charAt(i)]++;
        }

        int longest = 0;
        boolean addOne = false;
        for(int i=65 ; i<chars.length ; i++) {
            if(chars[i] % 2 == 1) {
                addOne = true;
            }
            longest += (chars[i] % 2 == 0 ? chars[i] : chars[i] - 1);
        }

        return addOne ? longest + 1 : longest;
    }
}
