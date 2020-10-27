package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MaximumProductOfTwoElementInArray {

    public static void main(String[] args) {

        MaximumProductOfTwoElementInArray obj = new MaximumProductOfTwoElementInArray();
    }

    public int maxProduct(int[] nums) {

        if(nums == null)
            return 0;

        int a = 0, b = 0;
        for(int i=0 ; i<nums.length ; i++) {
            if(nums[i] > a) {
                b = a;
                a = nums[i];
            } else if(nums[i] > b) {
                b = nums[i];
            }
        }
        return (a-1) * (b-1);
    }
}
