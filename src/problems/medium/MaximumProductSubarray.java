package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 24-11-2020
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {

        MaximumProductSubarray obj = new MaximumProductSubarray();

        int[] nums = {2, 3, -2, 4};
        System.out.println(obj.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int max = Integer.MIN_VALUE, current = 1;
        for(int i=0 ; i<nums.length ; i++) {
            current *= nums[i];
            max = Math.max(max, current);
            if(current == 0) current = 1;
        }

        current = 1;
        for(int i=nums.length-1 ; i>=0 ; i--) {
            current *= nums[i];
            max = Math.max(max, current);
            if(current == 0) current = 1;
        }

        return max;
    }
}
