package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-01-2021
 */
public class PartitionToKEqualSumSubsets {

    public static void main(String[] args) {

        PartitionToKEqualSumSubsets obj = new PartitionToKEqualSumSubsets();

        int[] nums = {10, 10, 7, 7, 7, 7, 6, 6};
        int k = 3;

        System.out.println(obj.canPartitionKSubsets(nums, k));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        if(nums == null)
            return false;

        int total = 0;
        for(int n : nums) total += n;

        if(total % k != 0)
            return false;

        return canDivide(0, 0, total / k, k, nums, new boolean[nums.length]);
    }

    private boolean canDivide(int idx, int runningSum, int subSetSum, int k, int[] nums, boolean[] isUsed) {

        if(k == 1)
            return true;
        if(idx == nums.length || runningSum > subSetSum)
            return false;
        if(runningSum == subSetSum)
            return canDivide(0, 0, subSetSum, k-1, nums, isUsed);

        if(!isUsed[idx]) {
            isUsed[idx] = true;
            if(canDivide(idx+1, runningSum+nums[idx], subSetSum, k, nums, isUsed))
                return true;
            isUsed[idx] = false;
            return canDivide(idx+1, runningSum, subSetSum, k, nums, isUsed);
        }

        return canDivide(idx+1, runningSum, subSetSum, k, nums, isUsed);
    }
}
