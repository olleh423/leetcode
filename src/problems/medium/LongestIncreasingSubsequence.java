package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(obj.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int maxLength = 1;
        int[] DP = new int[n];
        Arrays.fill(DP, 1);

        for(int i=0 ; i<n ; i++) {
            for(int j=i+1 ; j<n ; j++) {
                if(nums[i] < nums[j]) {
                    DP[j] = Math.max(DP[j], 1 + DP[i]);
                    maxLength = Math.max(maxLength, DP[j]);
                }
            }
        }

        return maxLength;
    }
}
