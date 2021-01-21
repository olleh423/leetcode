package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-01-2021
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();

        int[] arr = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(obj.minSubArrayLen(s, arr));
    }

    public int minSubArrayLen(int s, int[] nums) {

        if(nums == null) return 0;

        int runningSum = 0;
        int i=0, j=0;
        int minLen = Integer.MAX_VALUE;

        while(j < nums.length) {

            runningSum += nums[j++];
            if(runningSum >= s) {

                while(runningSum >= s && i < j) {
                    minLen = Math.min(minLen, j-i);
                    runningSum -= nums[i++];
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
