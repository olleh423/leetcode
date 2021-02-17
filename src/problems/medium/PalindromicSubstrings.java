package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 13-02-2021
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {

        PalindromicSubstrings obj = new PalindromicSubstrings();

        String str = "abccba";
        System.out.println(obj.countSubstrings(str));
    }

    /*
     * count substring by extending the length of palindrome with even length and odd length
     */
    public int countSubstrings(String s) {

        if(s == null) return 0;

        int result = 0;
        for(int i=0 ; i<s.length() ; i++) {

            result += checkPalindrome(i, i, s);
            result += checkPalindrome(i, i+1, s);
        }

        return result;
    }

    private int checkPalindrome(int i, int j, String s) {
        int count = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--; j++;
        }
        return count;
    }

    /*
     * count substrings with DP table
     */
    public int countSubstrings_2(String s) {

        if(s == null) return 0;

        int n = s.length();
        boolean[][] T = new boolean[n][n];

        int result = 0;
        for(int i=0 ; i<n ; i++) {
            result += 1;
            T[i][i] = true;
        }

        for(int i=0 ; i<n-1 ; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                result += 1;
                T[i][i+1] = true;
            }
        }

        for(int k=3 ; k<=n ; k++) {
            for(int i=0 ; i<=n-k ; i++) {
                if(s.charAt(i) == s.charAt(i+k-1) && T[i+1][i+k-2]) {
                    result += 1;
                    T[i][i+k-1] = true;
                }
            }
        }

        return result;
    }
}
