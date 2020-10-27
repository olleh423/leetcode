package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class NumberOfGoodPairs {

    public static void main(String[] args) {

        NumberOfGoodPairs obj = new NumberOfGoodPairs();

        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(obj.numIdenticalPairs(nums));
    }

    public int numIdenticalPairs(int[] nums) {

        int total = 0;
        for(int i=0 ; i<nums.length ; i++) {
            for(int j=i+1 ; j<nums.length ; j++) {
                total += nums[i] == nums[j] ? 1 : 0;
            }
        }
        return total;
    }
}
