package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 08-02-2021
 */
public class TargetSum {

    public static void main(String[] args) {

        TargetSum obj = new TargetSum();
        int[] nums = {7,9,3,8,0,2,4,8,3,9};
        int S = 0;

        System.out.println(obj.findTargetSumWays(nums, S));
    }

    public int findTargetSumWays(int[] nums, int S) {

        if(nums == null)
            return 0;

        Map<String, Integer> DP = new HashMap<>();
        return solve(0, nums, S, 0, DP);
    }

    private int solve(int i, int[] nums, int S, int runningSum, Map<String, Integer> DP) {

        if(i == nums.length)
            return S == runningSum ? 1 : 0;

        String key = i + "-" + runningSum;
        if(DP.containsKey(key))
            return DP.get(key);

        int result = solve(i+1, nums, S, runningSum-nums[i], DP)
                    + solve(i+1, nums, S, runningSum+nums[i], DP);

        DP.put(key, result);
        return result;
    }
}
