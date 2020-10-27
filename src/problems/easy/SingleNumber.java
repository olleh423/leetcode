package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class SingleNumber {

    public static void main(String[] args) {

        SingleNumber obj = new SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(obj.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {

        if(nums == null) return 0;

        int xor = 0;
        for(int i=0 ; i<nums.length ; i++)
            xor ^= nums[i];

        return xor;
    }
}
