package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MaximumSubArray {

    public static void main(String[] args) {

        MaximumSubArray obj = new MaximumSubArray();
    }

    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int max = nums[0], total = 0;
        for(int i=0 ; i<nums.length ; i++) {
            total += nums[i];
            if(max < total) max = total;
            if(total < 0) total = 0;
        }
        return max;
    }
}
