package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
    }

    public int[] productExceptSelf(int[] nums) {

        if(nums == null || nums.length == 0)
            return null;

        int n = nums.length;
        int[] result = new int[n];

        for(int i=0, temp=1 ; i<n ; i++) {
            result[i] = temp;
            temp *= nums[i];
        }

        for(int i=nums.length-1, temp=1 ; i>=0 ; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }

        return result;
    }
}
