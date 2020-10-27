package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class RunningSumOf1DArray {

    public static void main(String[] args) {

        RunningSumOf1DArray obj = new RunningSumOf1DArray();
    }

    public int[] runningSum(int[] nums) {

        if(nums == null || nums.length == 0)
            return null;

        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];

        for(int i=1 ; i<nums.length ; i++)
            runningSum[i] = runningSum[i-1] + nums[i];

        return runningSum;
    }
}
