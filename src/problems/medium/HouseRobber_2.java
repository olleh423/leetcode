package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 18-01-2021
 */
public class HouseRobber_2 {

    public static void main(String[] args) {

        HouseRobber_2 obj = new HouseRobber_2();

        int[] nums = {6, 1, 5, 3, 2, 4};
        System.out.println(obj.rob(nums));
    }

    public int rob(int[] nums) {

        if(nums == null)
            return 0;

        if(nums.length == 1)
            return nums[0];

        return Math.max(getMaxMoney(nums, 0, nums.length-2), getMaxMoney(nums, 1, nums.length-1));
    }

    private int getMaxMoney(int[] nums, int start, int end) {

        int select = nums[start];
        int notSelect = 0;

        for(int i=start+1 ; i<=end ; i++) {
            int A = select;
            int B = Math.max(A, nums[i] + notSelect);
            notSelect = A;
            select = B;
        }

        return Math.max(select, notSelect);
    }
}
