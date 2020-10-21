package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
    }

    public int longestPalindromeSubseq(String s) {

        int[][] DP = new int[s.length()][s.length()];
        for(int i=0 ; i<DP.length ; i++)
            for(int j=0 ; j<DP[i].length ; j++)
                DP[i][j] = -1;

        return longest(s, 0, s.length()-1, DP);
    }

    public int longest(String s, int i, int j, int[][] DP) {

        if(i == j) return 1;

        if(i > j) return 0;

        if(DP[i][j] != -1) return DP[i][j];

        if(s.charAt(i) == s.charAt(j))
            DP[i][j] = 2 + longest(s, i+1, j-1, DP);
        else
            DP[i][j] = Math.max(longest(s, i, j-1, DP), longest(s, i+1, j, DP));

        return DP[i][j];
    }
}
