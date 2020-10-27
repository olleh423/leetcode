package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class RemoveElement {

    public static void main(String[] args) {

        RemoveElement obj = new RemoveElement();
    }

    public int removeElement(int[] nums, int val) {

        if(nums == null)
            return 0;

        int index = 0;
        for(int i=0 ; i<nums.length ; i++) {
            if(nums[i] == val) {
                index = i;
                break;
            }
        }

        int length = 0;

        for(int i = index ; i < nums.length ; i++) {
            if(nums[i] != val) {
                nums[index] = nums[i];
                index++;
            } else {
                length++;
            }
        }

        return nums.length - length;
    }
}
