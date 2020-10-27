package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ArrayPartitionSum_1 {

    public static void main(String[] args) {

        ArrayPartitionSum_1 obj = new ArrayPartitionSum_1();
    }

    public int arrayPairSum(int[] nums) {

        java.util.Arrays.sort(nums);

        int total = 0;
        for(int i=0 ; i<nums.length ; i+=2) {
            total += nums[i];
        }

        return total;
    }
}
