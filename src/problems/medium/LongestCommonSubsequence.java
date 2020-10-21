package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(obj.longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String A, String B) {

        int n = A.length();
        int m = B.length();
        int[][] DP = new int[n][m];
        for(int i=0 ; i<n ; i++) {
            int[] arr = new int[m];
            Arrays.fill(arr, -1);
            DP[i] = arr;
        }
        return lcs(A, B, 0, 0, DP);
    }

    private int lcs(String A, String B, int i, int j, int[][] DP) {

        if(i == A.length() || j == B.length()) return 0;

        if(DP[i][j] != -1) return DP[i][j];

        if(A.charAt(i) == B.charAt(j))
            return 1 + lcs(A, B, i+1, j+1, DP);

        DP[i][j] = Math.max(lcs(A, B, i+1, j, DP), lcs(A, B, i, j+1, DP));
        return DP[i][j];
    }
}
