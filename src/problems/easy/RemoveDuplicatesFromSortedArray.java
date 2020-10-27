package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 26-10-2020
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
    }

    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int index = 1;
        int recentNumber = nums[0];
        for(int i=1 ; i<nums.length ; i++) {
            if(nums[i] != recentNumber) {
                nums[index] = nums[i];
                recentNumber = nums[i];
                index++;
            }
        }

        return index;
    }
}
