package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MissingNumber {

    public static void main(String[] args) {

        MissingNumber obj = new MissingNumber();
    }

    public int missingNumber(int[] nums) {

        if(nums == null)
            return 0;

        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        for(int i=0 ; i<nums.length ; i++)
            sum -= nums[i];

        return sum;
    }
}
